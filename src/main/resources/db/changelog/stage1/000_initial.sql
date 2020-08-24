begin;

-- create database if not exists rw;
--
-- use rw;

-- СПРАВОЧНИК закрепленных за операторами дефектоскопов и путеизмерительных тележек - стр. 28-29 ТЗ
-- = таблица привязок ФИО оператора и дефектоскопа/тележки в БД (стр. 62 ТЗ)
create table if not exists defectoscopes_book (
  id BIGINT primary key auto_increment,
  type varchar(255),                	-- тип дефектоскопа (тележки)
  factory_number varchar(255),        -- заводской номер дефектоскопа (тележки)
  factory_year int  					-- год выпуска
  );

create table if not exists responsibles_book (         -- СПРАВОЧНИК ответственных лиц (=операторов)
  id BIGINT primary key auto_increment,
  lastname varchar(255),        -- фамилия
  name varchar(255),            -- имя
  patronym varchar(255));       -- отчество

create table if not exists responsibles_to_defectoscopes (
  id_responsible bigint,
  id_defectoscope bigint,
  primary key (id_responsible, id_defectoscope),
  foreign key (id_responsible) references responsibles_book(id),
  foreign key (id_defectoscope) references defectoscopes_book(id)
  );
create table if not exists check_entity (
  id bigint primary key auto_increment,
  check_date date,                   -- 1) Дата проверки
  -- ФК для инфо из defectoscope_book (СПРАВОЧНИК закрепленных за операторами дефектоскопов)
  responsible_id BIGINT,            -- 2) Фамилия оператора, тип дефектоскопа, № дефектоскопа
  constraint foreign key(responsible_id) references responsibles_book(id),
  defectoscope_id bigint,
  constraint foreign key(defectoscope_id) references defectoscopes_book(id),
  work_region varchar(255),          -- 3) Место работы оператора
  -- checked_track_info: Количество поверенных км, стрелочных переводов, сварных стыков, съездов
  main_track int,                    -- 4) Главных путей, км
  io_track int,                      -- 5) Приемо-отправочных путей, км
  arrow_track int,                   -- 6) Стрелочных переводов, шт
  welded_joint int,                  -- 7) Сварных стыков, шт
  connected_track int,               -- 8) Съездов, шт
  -- notice ПУ-2б
  notice_time datetime,         -- Время выдачи предупреждения (только ПУ-2б, графа 16)
  cancel_number int,            -- номер отмены предупреждения (графа 18 ПУ-2б)
  cancel_time datetime        -- время отмены предупреждения (графа 18 ПУ-2б)
  );

--
-- особенности описания рельс, которые встречаются только в ПУ-2
create table if not exists rail_particulars (
                                              id bigint primary key auto_increment,
  -- общее для двух видов ПУ-2
  packing_date date,             -- дата укладки (стат. - графа 8, главн. - графа 7)
  packing_fature varchar(255),   -- признак укладки (стат. - графа 10, главн. - графа 9)
  quality_category varchar(255), -- Категория качества (стат. - графа 11, главн. - графа 13)
  rail_kind varchar(255),        -- вид рельса (стат. - графа 13, главн. - графа 15)
  rail_group varchar(255),       -- группа рельса (стат. - графа 12, главн. - графа 14)
  -- (inner?) только для рельс, лежащих в стационарных, специальных и подъездных путях (ПУ-2)
  park varchar(50),             -- 1) Парк
  from_arrow int,               -- 3) от стрелки
  to_arrow int,       	      -- 4) до стрелки
  purpose_tra varchar(255),     -- 5) назанчение пути по ТРА
  track_length_from BIGINT,     -- 6) длина отрезка пути - от метра
  track_length_to BIGINT,       -- 7) длина отрезка пути - до метра
  clamp_kind varchar(255),      -- 14) вид рельсового скрепления
  -- только для рельс, лежащих в главных и приемо-отправочных путях (ПУ-2)
  arrow_number INT,              -- 5) № Стрелочного перевода
  segment_number int,            -- 6.1) № плети
  repair_type varchar(255),      -- 11) Вид ремонта (Характеристика переуложенных рельсов)
  validity_group varchar(255),   -- 12) Группа годности (Характеристика переуложенных рельсов)
  measuring_date date);          -- 17) дата промера

-- для ПУ-2 Ч.2 Ведомости рельсов, лежащих в главных и приемо-отправочных путях - графы 18-29 ПУ-2
-- подробности износа рельса
create table if not exists rail_fretting (
 id bigint primary key auto_increment,
 vertical INT,                 -- 18) вертикальный,
 active_side INT,              -- 19) боковой рабочей грани,
 inactive_side INT,            -- 20) боковой нерабочей грани,
 crush_clinch INT,             -- 21) смятие и провисание стыка,
 ripply_fretting INT,          -- 22) волнообразный износ.
 fusing_date date,             -- 23) дата наплавки
 polish_date date,             -- 24) дата шлифовки
 polish_kind date,             -- 25) вид шлифовки
 defect_code BIGINT,           -- 26) код дефекта (СПРАВОЧНИК)
 clamp_kind varchar(255),      -- 27) вид рельсового скрепления
 tonnage_before bigint,        -- 28) Пропущенный тоннаж - до переукладки
 tonnage_after bigint);        -- 29) Пропущенный тоннаж - после переукладки

-- Место, где обнаружен деф/остродеф. рельс + Хар-ка рельса (старт с ПУ-27) + иные ПУ
create table if not exists rails (
  id bigint primary key auto_increment,
  -- region info (ПУ-27: графы 9-14; ПУ-2а/ПУ-2б: графы 4-9)
  subdivision_number int,       -- 9) № околотка
  track_number int,             -- 10) № пути
  station_or_km varchar(255),   -- 11) КМ или название станции
  picket_number int,            -- 12) № ПК (пикет)
  section_number int,           -- 13) № Звена
  slot varchar(255),            -- 14) нитка (правая/ левая)
  -- region info для натурных осмотров и др.
  track_part int,               -- ПЧ - путевая часть
  track_title varchar(255),     -- наименование участка
  ferry varchar(255),           -- перегон
  -- rail_description харакстеристика рельса (ПУ-27: графы 15-18; ПУ-2а/ПУ-2б: графы 10-13)
  factory_mark varchar(255),    -- 15) Марка завода,
  factory_year date,            -- 16) Год прокатки,
  rail_type varchar(255),       -- 17) тип рельса,
  rail_length BIGINT,           -- 18) длина рельса.
  particulars_id bigint,        -- особенности описания рельс, которые встречаются только в ПУ-2а и/или в ПУ-2б
  constraint foreign key (particulars_id) references rail_particulars(id),
  fretting_id bigint,           -- подробности износа рельса, только для ПУ-2 - графы 18-29 ПУ-2
  constraint foreign key (fretting_id) references rail_fretting(id),
  change_date datetime);        -- дата замены (ПУ-2а графа 17, ПУ-2 (галвн.) - графа 30), время замены (ПУ-2б графа 17)

create table if not exists defects (
  id bigint primary key auto_increment,
  -- (старт с ПУ-27, графы: 19-24)
  code varchar(255),            -- 19) код дефекта (справочник) (ПУ-2а/2б графа 14)
  deep INT,                     -- 20) глубина дефекта (H), мм (только ПУ-2а, графа 15)
  length INT,                   -- 21) длина дефекта (L), мм (только ПУ-2а, графа 16)
  detect_time datetime,         -- 22) время обнаружения (только ПУ-2б, графа 15)
  notice_number varchar(255),            -- 23) Кому выдано уведомление (ПД - true, ПДБ - false)
  comments varchar(255),        -- 24) Примечание
  place_comment varchar(255),   -- доп.инфо о расположении дефектного места в рельсе (Ведомость ВД)
  defect_group varchar(255),
  rail_id bigint,
  foreign key (rail_id) references rails(id),
  check_entity_id bigint,
  foreign key (check_entity_id) references check_entity(id)
  );   -- группа предполагаемого дефекта (Ведомость ВД)

create table if not exists departments_book (                                      -- СПРАВОЧНИК подразделений (стр. 21 ТЗ)
                                              id BIGINT primary key auto_increment,              -- Идентификатор подразделения
                                              parent_department_id INT,                          -- Идентификатор родительского подразделения
                                              department varchar(255));

create table if not exists roles (      -- для Ролей
                                   id bigint primary key auto_increment,
                                   role varchar(50) not null);

create table if not exists users (
                                   id BIGINT primary key auto_increment,
                                   employee_number varchar(255) not null unique, -- табельный номер (в ТЗ (стр.21) тип данных - текст)
  username varchar(255),       -- email
  password varchar(255),
  lastname varchar(255),       -- фамилия
  name varchar(255),           -- имя
  patronym varchar(255),       -- отчество
  position varchar(255),       -- должность работника
  department_id BIGINT,        -- структурное подразделение (FK к справочнику подразделений)
  constraint foreign key(department_id) references departments_book(id),
  cell_phone varchar(255),      -- тел. рабочий (для справочника ответственных лиц, стр. 21 ТЗ)
  office_phone varchar(255),    -- тел. мобильный
  home_phone  varchar(255),     -- домашний телефон (в мокапе было)
  id_role bigint,               -- роль
  constraint foreign key (id_role) references roles(id));

create table if not exists user_tokens (
  token varchar(255) primary key not null,
  type varchar(255) not null,
  user_id BIGINT not null,
  constraint foreign key(user_id) references users(id),
  expires datetime not null);

commit;