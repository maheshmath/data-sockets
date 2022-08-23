CREATE TABLE datasocket
(
    
    id varchar(10) NOT NULL,
    name varchar(50) NOT NULL ,
    properties json NOT NULL,
    active_state varchar(1) NOT NULL,
    created_by varchar(10) NOT NULL,
    created_on date NOT NULL,
    PRIMARY KEY (id)

);