package com.dms.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dms.dto.MessageDto;
import com.dms.entity.Messages;
import com.dms.entity.Message_Send;

@Repository
public class MessageDaoImpl implements MessageDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Messages> viewAllMessage() {
		// TODO Auto-generated method stub
		List<Messages> message_list=sessionFactory.getCurrentSession().createCriteria(Messages.class).list();
		return message_list;
	}

	@Override
	public Messages searchMessage(Messages message) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Messages sms=(Messages) session.get(Messages.class, message.getId());
		return sms;
	}

	@Override
	public void deleteMessage(Messages message) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Messages delete_message=(Messages) session.get(Messages.class,message.getId());
		session.delete(delete_message);
		session.flush();
		
	}

	@Override
	public long saveMessage(Messages message) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		long id=(long)session.save(message);
		return id;
	}

	@Override
	public void sendMessage(Message_Send msgSend) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(msgSend);
	}

	@Override
	public List<MessageDto> getSentMessage(long id) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Messages.class)
				.createAlias("sender", "s", JoinType.LEFT_OUTER_JOIN)
				;
			c.setProjection(Projections.projectionList()
					.add(Projections.property("id"),"id")
					.add(Projections.property("send_date"),"sendDate")
					.add(Projections.property("title"),"title")
					.add(Projections.property("description"),"description")
					);
			c.add(Restrictions.eq("s.id", id));
			c.setResultTransformer(Transformers.aliasToBean(MessageDto.class));
		return c.list();
	}

	@Override
	public List<MessageDto> getReceivedMessage(long id) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Message_Send.class)
				.createAlias("receiver", "r", JoinType.LEFT_OUTER_JOIN)
				.createAlias("message", "m", JoinType.LEFT_OUTER_JOIN)
				.createAlias("m.sender", "s", JoinType.LEFT_OUTER_JOIN)
				;
			c.setProjection(Projections.projectionList()
					.add(Projections.property("m.id"),"id")
					.add(Projections.property("m.title"),"title")
					.add(Projections.property("m.send_date"),"sendDate")
					.add(Projections.property("s.name"),"senderName")
					.add(Projections.property("received_date"),"receivedDate")
					.add(Projections.property("m.description"),"description")
					);
			c.add(Restrictions.eq("r.id", id));
			c.setResultTransformer(Transformers.aliasToBean(MessageDto.class));
		return c.list();
	}
	
	@Override
	public MessageDto getMessage(long msgId, long userId) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Messages.class)
				.createAlias("sender", "s", JoinType.LEFT_OUTER_JOIN)
				;
			c.setProjection(Projections.projectionList()
					.add(Projections.property("id"),"id")
					.add(Projections.property("send_date"),"sendDate")
					.add(Projections.property("s.name"),"senderName")
					.add(Projections.property("title"),"title")
					.add(Projections.property("description"),"description")
					);
			c.add(Restrictions.eq("id", msgId));
			
			c.setResultTransformer(Transformers.aliasToBean(MessageDto.class));
		return (MessageDto)c.uniqueResult();
	}
	@Override
	public void updateReceiveDate(long id,long userId) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = dFormat.format(new Date());  
		Date date=new Date();
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SQLQuery query=getCurrentSession().createSQLQuery("update message_send set received_date=:recDate where message_id=:id and receiver_id=:recId");
		query.setParameter("id", id);
		query.setParameter("recDate", date);
		query.setParameter("recId", userId);
		int status=query.executeUpdate();
		System.out.println(status);
	}
	@Override
	public Messages getMessage(long msgId) {
		// TODO Auto-generated method stub
		Messages sms=(Messages) getCurrentSession().get(Messages.class,msgId);
		return sms;
	}
	@Override
	public List<MessageDto> incomeMessage(long userId) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Message_Send.class)
				.createAlias("receiver", "r", JoinType.LEFT_OUTER_JOIN)
				.createAlias("message", "m", JoinType.LEFT_OUTER_JOIN)
				.createAlias("m.sender", "s", JoinType.LEFT_OUTER_JOIN)
				;
			c.setProjection(Projections.projectionList()
					.add(Projections.property("m.id"),"id")
					.add(Projections.property("m.title"),"title")
					.add(Projections.property("m.send_date"),"sendDate")
					.add(Projections.property("s.name"),"senderName")
					.add(Projections.property("received_date"),"receivedDate")
					.add(Projections.property("m.description"),"description")
					);
			c.add(Restrictions.eq("s.id", userId));
			c.add(Restrictions.eq("received_date", null));
			c.setResultTransformer(Transformers.aliasToBean(MessageDto.class));
		return c.list();
	}

}
