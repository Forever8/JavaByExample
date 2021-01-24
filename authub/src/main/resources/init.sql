CREATE TABLE users (
    id SERIAL,
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    status VARCHAR(255) DEFAULT 'active' NOT NULL
);

CREATE TABLE authorities (
    id SERIAL,
    username VARCHAR(255) NOT NULL,
    authority VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX authorities_unique_index ON authorities(username, authority);