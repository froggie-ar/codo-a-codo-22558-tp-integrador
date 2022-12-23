CREATE TABLE `personas` (
  `id` bigint(20) NOT NULL auto_increment,
  `per_nombre` varchar(50) NOT NULL,
  `per_apellido` varchar(50) NOT NULL,
  `per_dni` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_per_dni` (`per_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
