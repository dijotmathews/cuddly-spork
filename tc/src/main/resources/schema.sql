create table products (
      id uuid DEFAULT uuid_generate_v4 (),
      code varchar(255) not null,
      name varchar(255) not null,
      price numeric(5,2) not null,
      PRIMARY KEY (id),
      UNIQUE (code)
);