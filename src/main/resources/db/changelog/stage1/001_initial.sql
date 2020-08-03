begin;

alter table defects rename column notice_number to notice_target;        -- исправление имени поля и колонки - графа 23 ПУ-27

alter table check_entity add notice_number int after connected_track;    -- пропущенное поле (колонка) - графа 16 и ПУ-2б

-- переноc графы 16, 18 ПУ-2б из Check_enttity в Defect (т.к. предупреждение (№, время, отмена...) относится к дефекту, а не к проверке)

alter table check_entity drop column notice_number;
alter table check_entity drop column notice_time;
alter table check_entity drop column cancel_number;
alter table check_entity drop column cancel_time;

alter table defects add notice_number int after defect_group;
alter table defects add notice_time int after notice_number;
alter table defects add cancel_number int after notice_time;
alter table defects add cancel_time int after cancel_number;

commit;