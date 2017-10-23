package com.hfax.openplatform.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LTMapper {

	@Insert("INSERT INTO lt_pubinfo (deviceid, timestamp, devname, type, cmd, msgid, datatype, usr, pwd) VALUES (#{deviceid}, #{timestamp}, #{devname}, #{type}, #{cmd}, #{msgid}, #{datatype}, #{usr}, #{pwd})")
	Boolean insert_pubinfo(@Param("deviceid") String deviceid, @Param("timestamp") String timestamp, @Param("devname") String devname, @Param("type") String type, @Param("cmd") String cmd, @Param("msgid") String msgid, @Param("datatype") String datatype, @Param("usr") String usr, @Param("pwd") String pwd);

	@Insert("INSERT INTO lt_gen_detail (prs1, temp1, lev1) VALUES (#{prs1}, #{temp1}, #{lev1})")
	Boolean insert_gen_detail(@Param("prs1") String prs1, @Param("temp1") String temp1, @Param("lev1") String lev1);
}
