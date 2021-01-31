INSERT INTO test_groups (name,test_value) VALUES
('performance',15),
('corner cases',10),
('numerical stability',20),
('memory usage',10);

INSERT INTO test_cases (id,group_name,status) VALUES
(13,'memory usage','OK'),
(14,'numerical stability','OK'),
(15,'memory usage','ERROR'),
(16,'numerical stability','OK'),
(17,'numerical stability','OK'),
(18,'performance','ERROR'),
(19,'performance','ERROR'),
(20,'memory usage','OK'),
(21,'numerical stability','OK');

select name,
(SELECT COUNT(*) FROM test_cases WHERE test_cases.group_name=test_groups.name) as "all_test_cases",
(SELECT COUNT(*) FROM test_cases WHERE test_cases.group_name=test_groups.name AND test_cases.status like 'OK') as "passed_test_cases",
(SELECT COUNT(*) FROM test_cases WHERE test_cases.group_name=test_groups.name AND test_cases.status like 'OK')*test_value as "total_value"
FROM test_groups ORDER by total_value DESC,name ASC
