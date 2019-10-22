/* Users */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:VIEW', 'View current user full information', N'عرض بيانات مفصّلة عن المستخدم الفعّال');

/*INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:LIST', 'List all users related to current account with minimal details', N'عرض قائمة مختصرة بجميع المستخدمين المتعلقين بالحساب الحالي');*/

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:EDIT', 'Edit current user information', N'تعديل معلومات المستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:VIEW_ALL', 'View any user full information', N'عرض بيانات مفصّلة عن أي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:LIST_ALL', 'List all users with minimal details', N'عرض قائمة مختصرة بجميع المستخدمين');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (1, 'USERS:EDIT_ALL', 'Edit any user information', N'تعديل معلومات أي مستخدم');




/* Orders */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:ADD', 'Add a new order', N'إضافة طلب جديد');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:VIEW', 'View the details of a current user order', N'عرض تفاصيل طلب للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:LIST', 'List current user orders', N'عرض قائمة الطلبات للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:EDIT', 'Edit order details', N'تعديل تفاصيل الطلب');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:CANCEL', 'Cancel order for current user', N'إلغاء طلبية للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:VIEW_ALL', 'View the details any order', N'عرض تفاصيل أي طلب');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:LIST_ALL', 'List all orders', N'عرض قائمة بجميع الطلبات');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:EDIT_ALL', 'Edit any order details', N'تعديل تفاصيل أي طلب');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:REPLY_ALL', 'Accept or reject an order for any user', N'قبول أو رفض أي طلب لأي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (2, 'ORDERS:CLOSE_ALL', 'Close an order for any user', N'إغلاق طلب لأي مستخدم');


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
VALUES (3, 'LISTINGS:VIEW_ALL', 'View the details of any user listings', N'عرض تفاصيل العنصر في القائمة لأي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (3, 'LISTINGS:LIST_ALL', 'List any user listings', N'عرض قائمة العناصر لأي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (3, 'LISTINGS:EDIT_ALL', 'Edit any user listings', N'تعديل قائمة العناصر لأي مستخدم');


/* Proposals */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (4, 'PROPOSALS:LIST', 'List all proposals for current user', N'عرض قائمة الطلبات الخاصة بالمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (4, 'PROPOSALS:VIEW', 'View a proposal for current user', N'عرض تفاصيل قائمة طلب الخاصة بالمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (4, 'PROPOSALS:REPLY', 'Accept or reject a proposal for current user', N'قبول أو رفض أي عرض مقدم على الطلبات الخاصة بالمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (4, 'PROPOSALS:ADD_ALL', 'Add proposal to any user listings', N'إضافة عرض لأي قاثمة من الطلبات للمستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (4, 'PROPOSALS:LIST_ALL', 'List all proposals for any user', N'عرض قائمة الطلبات المقدمة لكل المستخدمين');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (4, 'PROPOSALS:VIEW_ALL', 'View a proposal for any user', N'عرض تفاصيل قائمة طلب مقدم لأي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (4, 'PROPOSALS:CANCEL_ALL', 'Cancel any proposal provided for any user', N'إلغاء أي طلب مقدم لأي مستخدم');


/* Payments */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (5, 'PAYMENTS:ADD', 'Add payment information for current user', N'إضافة تفاصيل الدفع للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (5, 'PAYMENTS:LIST', 'List previous list of payments for current user', N'عرض قائمة المدفوعات للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (5, 'PAYMENTS:VIEW', 'View details of a payment for current user', N'عرض تفاصيل الدفغ للمستخدم الحالي');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (5, 'PAYMENTS:ADD_ALL', 'Add payment information for any user', N'إضافة تفاصيل الدفع لأي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (5, 'PAYMENTS:LIST_ALL', 'List all payments from any user', N'عرض قائمة المدفوعات لأي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (5, 'PAYMENTS:VIEW_ALL', 'View details of any payment from any user', N'عرض تفاصيل الدفع لأي مستخدم');

INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (5, 'PAYMENTS:MANAGE_ALL', 'Manage any payment from any user', N'إدارة المدفوعات لأي مستخدم');


/* Roles */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (6, 'ROLES:PROMOTE_ALL', 'Promote a user to another role', N'ترقية دور أي مستخدم الى دور اخر');


/* Addresses */
INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
VALUES (7, 'ADDRESSES:ADD', 'Add an address to current user', N'إضافة عنوان للمستخدم الحالي');

-- INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
-- VALUES (7, 'ADDRESSES:ADD', 'Add an address to current user', N'إضافة عنوان للمستخدم الحالي');

-- INSERT INTO SPA_PRIVILEGE ( FK_PRIVILEGE_CATEGORY_ID, ACTION, NAME_EN, NAME_AR )
-- VALUES (7, 'ADDRESSES:ADD', 'Add an address to current user', N'إضافة عنوان للمستخدم الحالي');