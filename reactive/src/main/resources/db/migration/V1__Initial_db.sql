-- V1: basic message table

CREATE TABLE IF NOT EXISTS message (
    id   BIGSERIAL PRIMARY KEY,
    data VARCHAR(1024)
);

