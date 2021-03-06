CREATE USER IF NOT EXISTS ADMIN SALT 'ec3b308492d5fae4' HASH 'b42dcd32204fa84a51ce4fc689d070b4aca8714019bf8fc6f6732dc67e5f4d2e' ADMIN;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_13B7C76E_8B54_466D_9620_84517215E9E1 START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_A6CD4B41_22CE_4C1F_A4AE_26CA9076BD5B START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_E7D9C491_29D4_4D2E_86B9_6282D77B882C START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_68CD4C77_8A95_40BE_B5AC_3AE792CAD888 START WITH 1 BELONGS_TO_TABLE;
CREATE MEMORY TABLE PUBLIC.ENTRY( 
    ID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_68CD4C77_8A95_40BE_B5AC_3AE792CAD888) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_68CD4C77_8A95_40BE_B5AC_3AE792CAD888, 
    ENTER DATETIME NOT NULL, 
    LEAVE DATETIME, 
    PERSON_ID BIGINT NOT NULL 
);
ALTER TABLE PUBLIC.ENTRY ADD CONSTRAINT PUBLIC.CONSTRAINT_3 PRIMARY KEY(ID);
-- 6 +/- SELECT COUNT(*) FROM PUBLIC.ENTRY;
CREATE MEMORY TABLE PUBLIC.GAME( 
    ID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_13B7C76E_8B54_466D_9620_84517215E9E1) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_13B7C76E_8B54_466D_9620_84517215E9E1, 
    NAME VARCHAR(255) NOT NULL 
);
ALTER TABLE PUBLIC.GAME ADD CONSTRAINT PUBLIC.CONSTRAINT_2 PRIMARY KEY(ID);
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.GAME;
CREATE MEMORY TABLE PUBLIC.PERSON( 
    ID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_A6CD4B41_22CE_4C1F_A4AE_26CA9076BD5B) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_A6CD4B41_22CE_4C1F_A4AE_26CA9076BD5B, 
    NAME VARCHAR(255) NOT NULL 
);
ALTER TABLE PUBLIC.PERSON ADD CONSTRAINT PUBLIC.CONSTRAINT_8 PRIMARY KEY(ID);
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.PERSON;
CREATE MEMORY TABLE PUBLIC.PLAY( 
    ID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_E7D9C491_29D4_4D2E_86B9_6282D77B882C) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_E7D9C491_29D4_4D2E_86B9_6282D77B882C, 
    END DATETIME, 
    START DATETIME NOT NULL, 
    GAME_ID BIGINT NOT NULL, 
    PERSON_ID BIGINT NOT NULL 
);
ALTER TABLE PUBLIC.PLAY ADD CONSTRAINT PUBLIC.CONSTRAINT_25 PRIMARY KEY(ID);
-- 11 +/- SELECT COUNT(*) FROM PUBLIC.PLAY;
ALTER TABLE PUBLIC.GAME ADD CONSTRAINT PUBLIC.UKJARE70VQQTI665DS3B2EH7RK8 UNIQUE(NAME);
ALTER TABLE PUBLIC.PLAY ADD CONSTRAINT PUBLIC.FKH3TPMWW81SY7I4EJ2IX737XEC FOREIGN KEY(PERSON_ID) REFERENCES PUBLIC.PERSON(ID) NOCHECK;
ALTER TABLE PUBLIC.PLAY ADD CONSTRAINT PUBLIC.FKH5DYRWENQCPIUQBSL417IOQHS FOREIGN KEY(GAME_ID) REFERENCES PUBLIC.GAME(ID) NOCHECK;
ALTER TABLE PUBLIC.ENTRY ADD CONSTRAINT PUBLIC.FKS8BMEQ648Q8K65X9045QYH844 FOREIGN KEY(PERSON_ID) REFERENCES PUBLIC.PERSON(ID) NOCHECK;
