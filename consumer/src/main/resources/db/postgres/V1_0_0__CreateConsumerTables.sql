BEGIN;

CREATE TABLE ADDRESS (
  id             NUMERIC UNIQUE NOT NULL,
  building       VARCHAR(50),
  street         VARCHAR(50),
  town           VARCHAR(50),
  county         VARCHAR(50),
  postcode       VARCHAR(50)
);

COMMIT;