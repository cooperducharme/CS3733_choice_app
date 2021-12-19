INSERT INTO sys.choice (choice_id, title, description, member_count) VALUES 
	("samplechoiceid", "What Movie Are We Watching?", "we are gonna be watching a movie tomorrow, whats it gonna be?", 5);
    
INSERT INTO sys.alternative (alternative_id, text, choice_id) VALUES
	("samplealtid1", "The Avengers", "samplechoiceid"),
    ("samplealtid2", "Sonic The Hedgehog", "samplechoiceid");

INSERT INTO sys.team_member (team_member_id, choice_id, username, password) VALUES
	("sampleteamid1", "samplechoiceid", "Jeff", NULL),
    ("sampleteamid2", "samplechoiceid", "CoolKid69", NULL),
    ("sampleteamid3", "samplechoiceid", "SilentSally", NULL),
    ("sampleteamid4", "samplechoiceid", "SneakyTurtle", "iliketurtles");

INSERT INTO sys.reaction (reaction_id, team_member_id, alternative_id, isApprove) VALUES
	("samplereactid11", (SELECT team_member_id from sys.team_member WHERE username='Jeff'), "samplealtid1", TRUE),
    ("samplereactid21", (SELECT team_member_id from sys.team_member WHERE username='CoolKid69'), "samplealtid1", FALSE),
    ("samplereactid31", (SELECT team_member_id from sys.team_member WHERE username='SilentSally'), "samplealtid1", FALSE),
    ("samplereactid12", (SELECT team_member_id from sys.team_member WHERE username='Jeff'), "samplealtid2", TRUE),
    ("samplereactid22", (SELECT team_member_id from sys.team_member WHERE username='CoolKid69'), "samplealtid2", TRUE),
    ("samplereactid32", (SELECT team_member_id from sys.team_member WHERE username='SilentSally'), "samplealtid2", TRUE),
    ("samplereactid42", (SELECT team_member_id from sys.team_member WHERE username='SneakyTurtle'), "samplealtid2", FALSE);
    
INSERT INTO sys.feedback (feedback_id, team_member_id, alternative_id, explanation) VALUES
	("samplefeedbackid1", (SELECT team_member_id from sys.team_member WHERE username='Jeff'), "samplealtid1", "I like superhero :) :)"),
    ("samplefeedbackid2", (SELECT team_member_id from sys.team_member WHERE username='CoolKid69'), "samplealtid1", "normies!!! I hate avengers thsi is me showing that we are cool and like multiline comments in this application isnt that so awesome omg look at all these words :(((")