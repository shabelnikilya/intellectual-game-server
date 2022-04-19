CREATE TABLE questions (
	id SERIAL PRIMARY KEY,
	topic TEXT,
	text TEXT
)
CREATE TABLE answers (
	id SERIAL PRIMARY KEY,
	text TEXT,
	right_answer BOOLEAN,
	answer_id INT REFERENCES questions(id)
);