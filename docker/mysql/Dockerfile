FROM mysql:8.0.32
ENV MYSQL_ROOT_PASSWORD=root
WORKDIR opt/app

COPY data.sql docker/mysql/
COPY schema.sql docker/mysql/

