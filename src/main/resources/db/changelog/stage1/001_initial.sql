begin;

-- переноc графы 16, 18 ПУ-2б из Check_enttity в Defect (т.к. предупреждение (№, время, отмена...) относится к дефекту, а не к проверке)
alter table check_entity drop column notice_time;
alter table check_entity drop column cancel_number;
alter table check_entity drop column cancel_time;

alter table defects modify column notice_number int after defect_group;
alter table defects add column notice_time int after notice_number;
alter table defects add cancel_number int  after notice_time;
alter table defects add cancel_time int  after cancel_number;
alter table defects add notice_target  int after detect_time; -- исправление имени поля и колонки - графа 23 ПУ-27
-- было notice_number


commit;