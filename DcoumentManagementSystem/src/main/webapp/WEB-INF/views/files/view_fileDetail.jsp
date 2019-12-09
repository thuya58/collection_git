<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Received File</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			
						<table class="table table-bordered dataTable" id="dataTable"
							width="100%" cellspacing="0" role="grid"
							aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th>Send Date</th>
									<th>Sender Name</th>
									<th>Receive Date</th>
									<td>File Name</td>
								</tr>
							</thead>

							<tbody>
									<tr>
										<td>${share_file.send_date}</td>
										<td>${share_file.senderName}</td>
										<td>${share_file.receive_date}</td>
										<td>${share_file.fileName}</td>
									</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>