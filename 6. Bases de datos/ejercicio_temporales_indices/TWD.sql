USE movies_db;
CREATE TEMPORARY TABLE TWD (
	`id` int(10) NOT NULL,
	`created_at` timestamp NULL DEFAULT NULL,
	`updated_at` timestamp NULL DEFAULT NULL,
	`title` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
	`number` int(10) unsigned DEFAULT NULL,
	`release_date` datetime NOT NULL,
	`rating` decimal(3,1) NOT NULL,
    `season_number` int(10) unsigned DEFAULT NULL
);

INSERT INTO TWD SELECT ep.id, ep.created_at, ep.updated_at, ep.title, ep.number, ep.release_date, ep.rating, sea.number
FROM series se JOIN seasons sea ON se.id = sea.serie_id JOIN episodes ep ON sea.id = ep.season_id
WHERE se.title LIKE 'The Walking Dead';

SELECT * FROM TWD WHERE season_number = 1;