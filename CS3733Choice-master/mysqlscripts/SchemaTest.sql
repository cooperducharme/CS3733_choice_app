DROP SCHEMA IF EXISTS `test`;
CREATE SCHEMA `test`;
USE `test`;

CREATE TABLE IF NOT EXISTS test.choice(
	choice_id VARCHAR(36) NOT NULL,
    title VARCHAR(64) NOT NULL,
    description VARCHAR(128),
    createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    member_count INT NOT NULL,
    CONSTRAINT pk_choice PRIMARY KEY (choice_id)
) ENGINE = InnoDb DEFAULT CHAR SET=utf8;


CREATE TABLE IF NOT EXISTS test.alternative(
	alternative_id VARCHAR(36) NOT NULL,
    text VARCHAR(64) NOT NULL,
    choice_id VARCHAR(36) NOT NULL,
    CONSTRAINT pk_alternative PRIMARY KEY (alternative_id),
	CONSTRAINT fk_choice_alternative_idx FOREIGN KEY (choice_id) REFERENCES test.choice (choice_id)
    ON DELETE CASCADE
) ENGINE = InnoDb DEFAULT CHAR SET=utf8;

CREATE TABLE IF NOT EXISTS test.final_alternative(
	alternative_id VARCHAR(36) NOT NULL,
    choice_id VARCHAR(36) NOT NULL,
    CONSTRAINT pk_finalalternative PRIMARY KEY (choice_id),
	CONSTRAINT fk_finalaternative_alternative FOREIGN KEY (alternative_id) REFERENCES test.alternative (alternative_id)
    ON DELETE CASCADE,
	CONSTRAINT fk_finalalternative_choice FOREIGN KEY (choice_id) REFERENCES test.choice (choice_id)
    ON DELETE CASCADE
) ENGINE = InnoDb DEFAULT CHAR SET=utf8;

CREATE TABLE IF NOT EXISTS test.team_member(
	team_member_id VARCHAR(36) NOT NULL,
	choice_id VARCHAR(36) NOT NULL,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(64),
    CONSTRAINT pk_teammember PRIMARY KEY (team_member_id),
    CONSTRAINT fk_teammember_choice FOREIGN KEY (choice_id) REFERENCES test.choice (choice_id)
    ON DELETE CASCADE
) ENGINE = InnoDb DEFAULT CHAR SET=utf8;

CREATE TABLE IF NOT EXISTS test.reaction(
	reaction_id VARCHAR(36) NOT NULL,
    team_member_id VARCHAR(36) NOT NULL,
    alternative_id VARCHAR(36) NOT NULL,
    isApprove BOOLEAN NOT NULL,
    UNIQUE KEY (team_member_id, alternative_id),
    CONSTRAINT pk_reaction PRIMARY KEY (reaction_id),
    CONSTRAINT fk_reaction_teammember FOREIGN KEY (team_member_id) REFERENCES test.team_member (team_member_id)
    ON DELETE CASCADE,
    CONSTRAINT fk_reaction_alternative FOREIGN KEY (alternative_id) REFERENCES test.alternative (alternative_id)
    ON DELETE CASCADE
) ENGINE = InnoDb DEFAULT CHAR SET=utf8;

CREATE TABLE IF NOT EXISTS test.feedback(
	feedback_id VARCHAR(36) NOT NULL,
    team_member_id VARCHAR(36) NOT NULL,
    alternative_id VARCHAR(36) NOT NULL,
    explanation VARCHAR(1024) NOT NULL,
    createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_feedback PRIMARY KEY (feedback_id),
    CONSTRAINT fk_feedback_teammember FOREIGN KEY (team_member_id) REFERENCES test.team_member (team_member_id)
    ON DELETE CASCADE,
    CONSTRAINT fk_feedback_alternative FOREIGN KEY (alternative_id) REFERENCES test.alternative (alternative_id)
    ON DELETE CASCADE
) ENGINE = InnoDb DEFAULT CHAR SET=utf8;