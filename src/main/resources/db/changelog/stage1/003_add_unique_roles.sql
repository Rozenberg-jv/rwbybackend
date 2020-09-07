begin;

alter table users add unique (username);
alter table roles add unique (role);

  insert into roles value (null, "ROLE_ADMIN");
  insert into roles value  (null, "ROLE_EMPLOEEVD");
  insert into roles value (null, "ROLE_DEFEKTOSKOPIST");
  insert into roles value  (null, "ROLE_TEKHNIK");
  insert into roles value (null, "ROLE_DISPETCHER");
  insert into roles value  (null, "ROLE_TRACKMAN");
  insert into roles value  (null, "ROLE_LABORANT");
  insert into roles value  (null, "ROLE_GUEST");


commit;