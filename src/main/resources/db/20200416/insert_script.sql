INSERT INTO MESSAGE_M(
	message_id, message_nm, create_user, create_date, create_pgid, update_user, update_date, update_pgid)
	VALUES (1 , 'マスタ登録完了。次は台帳作成を行って下さい。','000000', now(), 'SYSTEM', '000000', now(), 'SYSTEM');


INSERT INTO MESSAGE_M(
	message_id, message_nm, create_user, create_date, create_pgid, update_user, update_date, update_pgid)
	VALUES (2 , '台帳作成完了。次は、棚卸依頼メールを送信してください。','000000', now(), 'SYSTEM', '000000', now(), 'SYSTEM');

