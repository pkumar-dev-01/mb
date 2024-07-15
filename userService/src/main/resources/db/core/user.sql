--  @version $Id: //product/DPS/version/11.3.1/templates/DPS/sql/user_ddl.xml#2 $$Change: 1510603 $
-- This file contains create table statements, which will configure your database for use with the new DPS schema.
-- Add the organization definition.  It's out of place, but since sps_user references it, it's got to be defined up here

create table sps_organization (
	org_id	varchar(40)	not null,
	name	nvarchar(254)	not null,
	description	nvarchar(254)	null,
	parent_org	varchar(40)	null
,constraint sps_organization_p primary key (org_id)
,constraint sps_orgnparnt_rg_f foreign key (parent_org) references sps_organization (org_id));

create index sps_orgparent_org on sps_organization (parent_org);
-- Default Profile User Template
-- Basic user info.  note: the password field size must be at a minimum 70 characters       if DPS stores a hash of the password and not the actual value.

create table sps_user (
	id	varchar(40)	not null,
	login	nvarchar(40)	not null,
	auto_login	tinyint	null,
	password	varchar(254)	null,
	password_salt	varchar(250)	null,
	password_kdf	varchar(40)	null,
	realm_id	varchar(40)	null,
	member	tinyint	null,
	first_name	nvarchar(40)	null,
	middle_name	nvarchar(40)	null,
	last_name	nvarchar(40)	null,
	user_type	integer	null,
	locale	integer	null,
	lastactivity_date	datetime	null,
	lastpwdupdate	datetime	null,
	generatedpwd	tinyint	null,
	registration_date	datetime	null,
	email	nvarchar(255)	null,
	email_status	integer	null,
	receive_email	integer	null,
	last_emailed	datetime	null,
	gender	integer	null,
	date_of_birth	date	null,
	securityStatus	integer	null,
	description	nvarchar(254)	null,
	accs_tkn_sgn_key	varchar(254)	null
,constraint sps_user_p primary key (id)
,constraint sps_user1_c check (auto_login in (0,1))
,constraint sps_user2_c check (member in (0,1)));

create unique index sps_user_u on sps_user (login,realm_id);

create table sps_contact_info (
	id	varchar(40)	not null,
	user_id	varchar(40)	null,
	prefix	nvarchar(40)	null,
	first_name	nvarchar(40)	null,
	middle_name	nvarchar(40)	null,
	last_name	nvarchar(40)	null,
	suffix	nvarchar(40)	null,
	job_title	nvarchar(100)	null,
	company_name	nvarchar(40)	null,
	address1	nvarchar(50)	null,
	address2	nvarchar(50)	null,
	address3	nvarchar(50)	null,
	city	nvarchar(30)	null,
	state	nvarchar(20)	null,
	postal_code	nvarchar(10)	null,
	county	nvarchar(40)	null,
	country	nvarchar(40)	null,
	phone_number	nvarchar(30)	null,
	fax_number	nvarchar(30)	null
,constraint sps_contact_info_p primary key (id));


create table sps_user_address (
	id	varchar(40)	not null,
	home_addr_id	varchar(40)	null,
	billing_addr_id	varchar(40)	null,
	shipping_addr_id	varchar(40)	null
,constraint sps_user_address_p primary key (id)
,constraint sps_usrddrssid_f foreign key (id) references sps_user (id));

create index sps_usr_adr_shp_id on sps_user_address (shipping_addr_id);
create index sps_usr_blng_ad_id on sps_user_address (billing_addr_id);
create index sps_usr_home_ad_id on sps_user_address (home_addr_id);

create table sps_other_addr (
	user_id	varchar(40)	not null,
	tag	nvarchar(42)	not null,
	address_id	varchar(40)	not null
,constraint sps_other_addr_p primary key (user_id,tag)
,constraint sps_othrddrusr_d_f foreign key (user_id) references sps_user (id));


create table sps_mailing (
	id	varchar(40)	not null,
	name	nvarchar(255)	null,
	subject	nvarchar(80)	null,
	uniq_server_id	varchar(255)	null,
	from_address	nvarchar(255)	null,
	replyto	nvarchar(255)	null,
	template_URL	varchar(255)	null,
	alt_template_URL	varchar(255)	null,
	batch_exec_id	varchar(40)	null,
	cc	longtext	null,
	bcc	longtext	null,
	send_as_html	integer	null,
	send_as_text	integer	null,
	params	longblob	null,
	start_time	datetime	null,
	end_time	datetime	null,
	status	integer	null,
	num_profiles	integer	null,
	num_sent	integer	null,
	num_bounces	integer	null,
	num_soft_bounces	integer	null,
	num_errors	integer	null,
	num_skipped	integer	null,
	fill_from_templ	tinyint	null,
	is_batched	tinyint	null,
	ignore_fatigue	tinyint	null,
	batch_size	integer	null,
	site_id	varchar(40)	null
,constraint sps_mailing_p primary key (id));


create table sps_mail_trackdata (
	mailing_id	varchar(40)	not null,
	map_key	varchar(254)	not null,
	map_value	varchar(254)	null
,constraint sps_mail_trackd_p primary key (mailing_id,map_key)
,constraint sps_mail_trackd_f foreign key (mailing_id) references sps_mailing (id));


create table sps_mail_batch (
	mailing_id	varchar(40)	not null,
	start_idx	integer	not null,
	uniq_server_id	varchar(254)	null,
	start_time	datetime	null,
	end_time	datetime	null,
	status	integer	null,
	num_profiles	integer	null,
	num_sent	integer	null,
	num_bounces	integer	null,
	num_errors	integer	null,
	num_skipped	integer	null,
	is_summarized	tinyint	null
,constraint sps_mail_batch_p primary key (mailing_id,start_idx)
,constraint sps_mailbatch_d_f foreign key (mailing_id) references sps_mailing (id));


create table sps_mail_server (
	uniq_server_id	varchar(254)	not null,
	last_updated	datetime	null
,constraint sps_mail_server_p primary key (uniq_server_id));


create table sps_user_mailing (
	mailing_id	varchar(40)	not null,
	user_id	varchar(40)	not null,
	idx	integer	not null
,constraint sps_user_mailing_p primary key (mailing_id,user_id)
,constraint sps_usrmmalng_d_f foreign key (mailing_id) references sps_mailing (id)
,constraint sps_usrmlngusr_d_f foreign key (user_id) references sps_user (id));

create index sps_u_mail_uid on sps_user_mailing (user_id);

create table sps_email_address (
	mailing_id	varchar(40)	not null,
	email_address	varchar(255)	not null,
	idx	integer	not null
,constraint sps_email_addres_p primary key (mailing_id,idx)
,constraint sps_emldmalng_d_f foreign key (mailing_id) references sps_mailing (id));

-- Organizations/roles

create table sps_role (
	role_id	varchar(40)	not null,
	type	integer	not null,
	version	integer	not null,
	name	nvarchar(254)	not null,
	description	nvarchar(254)	null
,constraint sps_role_p primary key (role_id));

-- Extending the user profile to include references to the roles that are assigned to this user

create table sps_user_roles (
	user_id	varchar(40)	not null,
	atg_role	varchar(40)	not null
,constraint sps_user_roles_p primary key (user_id,atg_role)
,constraint sps_usrrlsatg_rl_f foreign key (atg_role) references sps_role (role_id)
,constraint sps_usrrlsusr_d_f foreign key (user_id) references sps_user (id));

create index sps_usr_roles_id on sps_user_roles (atg_role);

create table sps_org_role (
	org_id	varchar(40)	not null,
	atg_role	varchar(40)	not null
,constraint sps_org_role_p primary key (org_id,atg_role)
,constraint sps_orgrlorg_d_f foreign key (org_id) references sps_organization (org_id)
,constraint sps_orgrlatg_rl_f foreign key (atg_role) references sps_role (role_id));

create index sps_org_rolerole on sps_org_role (atg_role);

create table sps_role_rel_org (
	organization	varchar(40)	not null,
	sequence_num	integer	not null,
	role_id	varchar(40)	not null
,constraint sps_role_rel_org_p primary key (organization,sequence_num)
,constraint sps_rolrorgnztn_f foreign key (organization) references sps_organization (org_id)
,constraint sps_rolrlrgrol_d_f foreign key (role_id) references sps_role (role_id));

create index sps_role_rel_org on sps_role_rel_org (role_id);

create table sps_relativerole (
	role_id	varchar(40)	not null,
	sps_function	nvarchar(40)	not null,
	relative_to	varchar(40)	not null
,constraint sps_relativerole_p primary key (role_id)
,constraint sps_reltreltv_t_f foreign key (relative_to) references sps_organization (org_id)
,constraint sps_reltvrlrol_d_f foreign key (role_id) references sps_role (role_id));

create index sps_relativerole on sps_relativerole (relative_to);

create table sps_user_org (
	organization	varchar(40)	not null,
	user_id	varchar(40)	not null
,constraint sps_user_org_p primary key (organization,user_id)
,constraint sps_usrrgorgnztn_f foreign key (organization) references sps_organization (org_id)
,constraint sps_usrrgusr_d_f foreign key (user_id) references sps_user (id));

create index sps_usr_orgusr_id on sps_user_org (user_id);

create table sps_user_org_anc (
	user_id	varchar(40)	not null,
	sequence_num	integer	not null,
	anc_org	varchar(40)	not null
,constraint sps_user_org_anc_p primary key (user_id,sequence_num)
,constraint sps_usrranc_rg_f foreign key (anc_org) references sps_organization (org_id)
,constraint sps_usrrgncusr_d_f foreign key (user_id) references sps_user (id));

create index sps_usr_org_ancanc on sps_user_org_anc (anc_org);

create table sps_org_chldorg (
	org_id	varchar(40)	not null,
	child_org_id	varchar(40)	not null
,constraint sps_org_chldorg_p primary key (org_id,child_org_id)
,constraint sps_orgcchild_rg_f foreign key (child_org_id) references sps_organization (org_id)
,constraint sps_orgcorg_d_f foreign key (org_id) references sps_organization (org_id));

create index sps_org_chldorg_id on sps_org_chldorg (child_org_id);

create table sps_org_ancestors (
	org_id	varchar(40)	not null,
	sequence_num	integer	not null,
	anc_org	varchar(40)	not null
,constraint sps_org_ancestor_p primary key (org_id,sequence_num)
,constraint sps_orgnanc_rg_f foreign key (anc_org) references sps_organization (org_id)
,constraint sps_orgnorg_d_f foreign key (org_id) references sps_organization (org_id));

create index sps_org_ancanc_org on sps_org_ancestors (anc_org);
-- Secondary organizations information

create table sps_user_sec_orgs (
	user_id	varchar(40)	not null,
	secondary_org_id	varchar(40)	not null
,constraint sps_usr_sec_orgs_p primary key (user_id,secondary_org_id)
,constraint sps_usrsecorg_rl_f foreign key (secondary_org_id) references sps_organization (org_id)
,constraint sps_usrsorgusr_d_f foreign key (user_id) references sps_user (id));

create index sps_usr_sec_org_id on sps_user_sec_orgs (secondary_org_id);
-- Adding the folder information

create table sps_folder (
	folder_id	varchar(40)	not null,
	type	integer	not null,
	name	nvarchar(254)	not null,
	parent	varchar(40)	null,
	description	nvarchar(254)	null
,constraint sps_folder_p primary key (folder_id)
,constraint sps_foldrparnt_f foreign key (parent) references sps_folder (folder_id));

create index sps_folderparent on sps_folder (parent);

create table sps_child_folder (
	folder_id	varchar(40)	not null,
	child_folder_id	varchar(40)	not null
,constraint sps_child_folder_p primary key (folder_id,child_folder_id)
,constraint sps_chilchild_fl_f foreign key (child_folder_id) references sps_folder (folder_id)
,constraint sps_chilfoldr_d_f foreign key (folder_id) references sps_folder (folder_id));

create index sps_chld_fldr_fld on sps_child_folder (child_folder_id);

create table sps_rolefold_chld (
	rolefold_id	varchar(40)	not null,
	role_id	varchar(40)	not null
,constraint sps_rolefold_chl_p primary key (rolefold_id,role_id)
,constraint sps_rolfrolfld_d_f foreign key (rolefold_id) references sps_folder (folder_id)
,constraint sps_rolfrol_d_f foreign key (role_id) references sps_role (role_id));

create index sps_rolfldchldrole on sps_rolefold_chld (role_id);
-- Adding the previous password information

create table sps_user_prevpwd (
	id	varchar(40)	not null,
	seq_num	integer	not null,
	prevpwd	varchar(200)	null
,constraint sps_prevpwd_p primary key (id,seq_num)
,constraint sps_prvpwd_d_f foreign key (id) references sps_user (id));


create table sps_profile_realm (
	id	varchar(40)	not null,
	name	nvarchar(255)	null,
	description	nvarchar(255)	null
,constraint sps_prfl_rlm_p primary key (id));

commit;

