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
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dms.dto.MessageDto;
import com.dms.dto.NotiDTO;
import com.dms.dto.Share_fileDto;
import com.dms.entity.Message_Send;
import com.dms.entity.Messages;
import com.dms.entity.Share_files;
  
@Repository
@org.springframework.transaction.annotation.Transactional
public class Share_fileDaoImp implements Share_fileDao{
	@Autowired
	private SessionFactory sessionFactory;
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<Share_files> viewAllShare_file() {
		// TODO Auto-generated method stub
		List<Share_files> list_share_file=getCurrentSession().createCriteria(Share_files.class).list();
		return list_share_file;
	}

	public Share_files searchShare_file(long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Share_files search_share_file=(Share_files) session.get(Share_files.class,id);
		
		return search_share_file;
	}

	public void deleteShare_file(Share_files share_file) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Share_files delete_share_file=(Share_files) session.get(Share_files.class,share_file.getId());
		session.delete(delete_share_file);
		session.flush();
	}

	public void saveOrUpdateShare_file(Share_files share_file) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(share_file);
	}
	public long saveShare_file(Share_files share_file) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		long id=(long) session.save(share_file);
		return id;
	}

	@Override
	public List<Share_files> receivedShareFile(long id) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Share_files.class)
				.createAlias("receiver_info", "r", JoinType.LEFT_OUTER_JOIN)
				.createAlias("file_detail", "f", JoinType.LEFT_OUTER_JOIN)
				.createAlias("f.user_info", "s", JoinType.LEFT_OUTER_JOIN)
				.createAlias("f.file_location", "l",JoinType.LEFT_OUTER_JOIN)
				;
		c.setProjection(Projections.projectionList()
				.add(Projections.property("r.name"),"receiverName")
				.add(Projections.property("send_date"),"send_date")
				.add(Projections.property("s.name")," senderName")
				.add(Projections.property("receive_date"),"receive_date")
				.add(Projections.property("f.name"),"fileName")
				.add(Projections.property("l.location"),"location")
				);
		c.add(Restrictions.eq("r.id", id));
		c.setResultTransformer(Transformers.aliasToBean(Share_fileDto.class));
		return c.list();
	}

	@Override
	public List<Share_fileDto> sendedShareFile(long id) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Share_files.class)
				.createAlias("receiver_info", "r", JoinType.LEFT_OUTER_JOIN)
				.createAlias("file_detail", "f", JoinType.LEFT_OUTER_JOIN)
				.createAlias("f.user_info", "s", JoinType.LEFT_OUTER_JOIN)
				.createAlias("f.file_location", "l",JoinType.LEFT_OUTER_JOIN)
				;
		c.setProjection(Projections.projectionList()
				.add(Projections.property("r.name"),"receiverName")
				.add(Projections.property("send_date"),"sendDate")
				.add(Projections.property("s.name"),"senderName")
				.add(Projections.property("receive_date"),"receivedDate")
				.add(Projections.property("f.name"),"fileName")
				.add(Projections.property("l.location"),"location")
				);
		c.add(Restrictions.eq("s.id", id));
		c.setResultTransformer(Transformers.aliasToBean(Share_fileDto.class));
		return c.list();
	}
	@Override
	public List<NotiDTO> getNotiList(long userId) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder("select noti.* from (\r\n" + 
				" select m.title as 'title',m.id as 'id','message' as 'notitype',u.name as 'senderName',DATE(m.send_date) as send_date from message_send ms LEFT JOIN messages m on ms.message_id=m.id left join user_info u ON m.sender_id=u.id where ms.received_date IS null and ms.receiver_id=:userId" + 
				" UNION ALL " + 
				" select 'File Share' as 'title',sf.id as 'id','sharefile' as 'notitype',u.name as 'senderName',DATE(sf.send_date) as send_date from share_files sf left join file_details fd ON sf.file_detailid=fd.id left join user_info u ON fd.user_id=u.id WHERE  sf.receive_date IS null and sf.receiver_id=:userId) as noti order by send_date desc;");
		SQLQuery query=getCurrentSession().createSQLQuery(sb.toString());
		query.addScalar("id",StandardBasicTypes.LONG);
		query.addScalar("senderName",StandardBasicTypes.STRING);
		query.addScalar("notitype",StandardBasicTypes.STRING);
		query.addScalar("title",StandardBasicTypes.STRING);
		query.addScalar("send_date",StandardBasicTypes.DATE);


		query.setParameter("userId", userId);
		query.setResultTransformer(Transformers.aliasToBean(NotiDTO.class));
		return query.list();
	}
	public void updateFileReceiveDate(long id,long userId) {
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
			System.out.println("time getting error");
		}
		SQLQuery query=getCurrentSession().createSQLQuery("update share_files set receive_date=:recDate where id=:id and receiver_id=:recId");
		query.setParameter("id", id);
		query.setParameter("recDate", date);
		query.setParameter("recId", userId);
		query.executeUpdate();
		
	}
	@Override
	public List<Share_fileDto> getReceiveShareFiles(long id) {
		// TODO Auto-generated method stub
		Criteria c=getCurrentSession().createCriteria(Share_files.class)
				.createAlias("receiver_info", "r", JoinType.LEFT_OUTER_JOIN)
				.createAlias("file_detailId", "f", JoinType.LEFT_OUTER_JOIN)
				.createAlias("f.user_info", "s", JoinType.LEFT_OUTER_JOIN)
				;
			c.setProjection(Projections.projectionList()
					.add(Projections.property("f.id"),"id")
					.add(Projections.property("send_date"),"send_date")
					.add(Projections.property("s.name"),"senderName")
					.add(Projections.property("receive_date"),"receive_date")
					.add(Projections.property("f.name"),"fileName")
					);
			c.add(Restrictions.eq("r.id", id));
			c.setResultTransformer(Transformers.aliasToBean(Share_fileDto.class));
		return c.list();
	}
	public Share_fileDto getShare_file(long fileId, long userId) {
		// TODO Auto-generated method stub
		System.out.println(fileId);
		Criteria c=getCurrentSession().createCriteria(Share_files.class)
				.createAlias("receiver_info", "r", JoinType.LEFT_OUTER_JOIN)
				.createAlias("file_detail", "f", JoinType.LEFT_OUTER_JOIN)
				.createAlias("f.user_info", "s", JoinType.LEFT_OUTER_JOIN)
				;
			c.setProjection(Projections.projectionList()
					.add(Projections.property("f.id"),"id")
					.add(Projections.property("send_date"),"send_date")
					.add(Projections.property("s.name"),"senderName")
					.add(Projections.property("receive_date"),"receive_date")
					.add(Projections.property("f.name"),"fileName")
					);
			c.add(Restrictions.eq("id",fileId ));
			c.setResultTransformer(Transformers.aliasToBean(Share_fileDto.class));
			Share_fileDto user=(Share_fileDto)c.uniqueResult();
		return user;
	}
	@Override
	public Share_fileDto SearchSharefile(String name) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
}
