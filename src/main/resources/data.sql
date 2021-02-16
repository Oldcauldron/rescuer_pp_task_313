
INSERT INTO `users` (`id`, `login`, `password`, `age`)
VALUES
(1,'admin','$2a$10$4C9cIxe0DAizDrd2mVr2fe7iZUKwZHNaF1up/S/KIPYj/LoryXuWq', 33),
(2,'user','$2a$10$uwfm.HjKXsStiR.49dsUO.I.JkDsR.26jSXwo3wEL8HYv06Wn3NM2', 33);

INSERT INTO `roles` (`id`, `role`)
VALUES
(1,'ROLE_ADMIN'),
(2,'ROLE_USER');

insert into users_roles
values
(1, 1),
(1, 2),
(2, 2);