INSERT INTO employees_m VALUES (
                                '111111', '高橋　花子', 'ﾀｶﾊｼ　ﾊﾅｺ', 'A','1100',
                                '112200','M','登用前', '2020-01-01', '2022-12-31', 'D',
                                'email@email.com',true,'1','SYSTEM',now(),'SYSTEM',
                                'SYSTEM',now(),'SYSTEM'

                               );


INSERT INTO system_params VALUES (
                                  '00001','事業企画','事業企画','事業企画','事業企画',
                                  '1100','1100','1100','1000',
                                  now(),now(),now(),now(),
                                  'SYSTEM',now(),'SYSTEM',
                                  'SYSTEM',now(),'SYSTEM'
                                 );


INSERT INTO MENUS (MENU_ID, MENU_NAME, DESCRIPTION, CREATE_USER, CREATE_DATE, CREATE_PGID, UPDATE_USER, UPDATE_DATE,
                   UPDATE_PGID)
VALUES (1, 'マスタ登録', 'Menu for higher rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (2, '台帳作成', 'Menu for higher rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (3, '棚卸依頼／リマインド送信', 'Menu for higher rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (4, '月次締め', 'Menu for higher rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (5, 'バッチスケジュール設定', 'Menu for higher rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (6, 'ユーザー権限設定', 'Menu for higher rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (7, '棚卸状況確認', 'Menu for higher rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (8, 'セキュリティカード棚卸', 'Menu for lower rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (9, 'VPNドングル棚卸', 'Menu for lower rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (10, '管理者', 'Parent Menu for higher rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (11, '棚卸', 'Parent Menu for lower rank user', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM');


INSERT INTO ROLES (ROLE_ID, ROLE_NAME, DESCRIPTION, CREATE_USER, CREATE_DATE, CREATE_PGID, UPDATE_USER, UPDATE_DATE,
                   UPDATE_PGID)
VALUES (1, 'Employee', 'Employee' , 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (2, 'HR', 'HR', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (3, 'IT Infrastructure', 'IT Infrastructure', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (4, 'Business Planning', 'Business Planning', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (5, 'Manager', 'Manager', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (6, 'Security Committee', 'Security Committee', 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM');



INSERT INTO ROLE_MENU_PERMISSIONS (ROLE_MENU_PERMISSION_ID, MENU_ID, ROLE_ID, CREATE_USER, CREATE_DATE, CREATE_PGID,
                                   UPDATE_USER, UPDATE_DATE, UPDATE_PGID)
VALUES (1, 3, 1, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (2, 8, 1, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (3, 9, 1, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (4, 10, 1, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (5, 11, 1, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (6, 1, 2, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (7, 10, 2, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (8, 1, 3, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (9, 10, 3, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (10, 1, 4, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (11, 2, 4, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (12, 3, 4, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (13, 4, 4, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (14, 5, 4, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (15, 6, 4, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (16, 7, 4, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (17, 10, 4, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (18, 1, 5, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (19, 6, 5, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (20, 7, 5, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (21, 10, 5, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (22, 3, 6, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (23, 8, 6, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (24, 9, 6, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (25, 10, 6, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM'),
       (26, 11, 6, 'SYSTEM', now(), 'SYSTEM', 'SYSTEM', now(), 'SYSTEM');