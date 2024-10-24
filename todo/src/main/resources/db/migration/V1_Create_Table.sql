CREATE TABLE if not exists todo (
    id uuid,
    name varchar(250),
    description varchar(250),
    deadline timestamp,
    is_done boolean,
    created_at timestamp,
    updated_at timestamp,
    PRIMARY KEY (id)
);