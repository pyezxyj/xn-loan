部署步骤：
1，eclipse导出war包

2. 本地war包上传至服务器
   scp -P 57652 xn-b2cmall.war root@121.43.101.148:/home  
   T6dh%$%$ss1

3. 备份原先配置(如果第一次部署，跳过此步骤)
  ssh root@121.43.101.148 -p 57652

  cd /home/wwwroot/b2cmall/tomcat_b2cmall/webapps
  cp ./xn-b2cmall/WEB-INF/classes/application.properties .
  cp ./xn-b2cmall/WEB-INF/classes/config.properties .
  rm -rf xn-b2cmall.war
  rm -rf xn-b2cmall
  mv /home/xn-b2cmall.war .
  
4. 已备份配置文件放回原处,重启tomcat
  mv -f application.properties ./xn-b2cmall/WEB-INF/classes/
  mv -f config.properties ./xn-b2cmall/WEB-INF/classes/
  
  ../bin/shutdown.sh
  ../bin/startup.sh
  
6. 验证程序
  http://121.43.101.148:6402/xn-b2cmall/api

