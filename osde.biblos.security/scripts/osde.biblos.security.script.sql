CREATE PROCEDURE [dbo].[sp_assign_role_allusers] @role_key nvarchar(30)
AS
insert into users_cms_roles  (id,user_id, role_id)
select LOWER(NEWID()),u.userId as user_id, cr.id as role_id from User_ u, cms_role cr
where cr.role_key = @role_key
and u.userId not in (select ucr.user_id from users_cms_roles ucr
inner join cms_role cr on cr.id = ucr.role_id 
and cr.role_key  = @role_key)
