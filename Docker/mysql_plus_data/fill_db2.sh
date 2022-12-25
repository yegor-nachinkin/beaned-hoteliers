#!/usr/bin/bash
mysql -uroot -pmysql mysql<<EOFMYSQL
source /usr/share/hoteliers.sql
EOFMYSQL
echo "Done."
