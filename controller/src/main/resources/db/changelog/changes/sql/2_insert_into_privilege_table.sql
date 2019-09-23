/* Users */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:VIEW', 'View current user full information', N'عرض بيانات مفصّلة عن المستخدم الفعّال');

/*INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:LIST', 'List all users related to current account with minimal details', N'عرض قائمة مختصرة بجميع المستخدمين المتعلقين بالحساب الحالي');*/

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:EDIT', 'Edit current user information', N'تعديل معلومات المستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:VIEWALL', 'View any user full information', N'عرض بيانات مفصّلة عن أي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:LISTALL', 'List all users with minimal details', N'عرض قائمة مختصرة بجميع المستخدمين');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:EDITALL', 'Edit any user information', N'تعديل معلومات أي مستخدم');




/* Orders */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:ADD', 'Add a new order', N'إضافة طلب جديد');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:VIEW', 'View the details of a current user order', N'عرض تفاصيل طلب للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:LIST', 'List current user orders', N'عرض قائمة الطلبات للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:EDIT', 'Edit order details', 'تعديل تفاصيل الطلب'N);

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:VIEWALL', 'View the details any order', 'عرض تفاصيل أي طلب'N);

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:LISTALL', 'List all orders', N'عرض قائمة بجميع الطلبات');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:EDITALL', 'Edit any order details', N'تعديل تفاصيل أي طلب');


/* Listings */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (3, 'LISTINGS:ADD', 'Add a new listing', N'إضافة عنصر جديد في القائمة');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (3, 'LISTINGS:VIEW', 'View the details of a current user listings', N'عرض تفاصيل العنصر في القائمة للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (3, 'LISTINGS:LIST', 'List current user listings', N'عرض قائمة العناصر للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (3, 'LISTINGS:EDIT', 'Edit current user listings', N'تعديل قائمة العناصر للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (3, 'LISTINGS:VIEWALL', 'View the details of any user listings', N'عرض تفاصيل العنصر في القائمة لأي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (3, 'LISTINGS:LISTALL', 'List any user listings', N'عرض قائمة العناصر لأي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (3, 'LISTINGS:EDITALL', 'Edit any user listings', N'تعديل قائمة العناصر لأي مستخدم');

-- TODO: Fill in correct privileges for Proposals and Payments
/* Proposals */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR ) VALUES ('PROPOSALS:ADD');
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR ) VALUES ('PROPOSALS:LIST');
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR ) VALUES ('PROPOSALS:VIEW');
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR ) VALUES ('PROPOSALS:REPLY');



/* Payments */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR ) VALUES ('PAYMENTS:ADD');
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR ) VALUES ('PAYMENTS:LIST');
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR ) VALUES ('PAYMENTS:VIEW');
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR ) VALUES ('PAYMENTS:MANAGE');