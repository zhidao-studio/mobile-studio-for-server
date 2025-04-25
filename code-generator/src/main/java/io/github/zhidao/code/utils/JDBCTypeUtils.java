package io.github.zhidao.code.utils;

public class JDBCTypeUtils {

	//这里对mysql和oracle都有的类型，jdbctype按oracle的来
	public static String dataType2JdbcTypeOracle(String dataType){
		String jdbcType = null;
		switch(dataType){
			/*Oracle类型*/
			case "VARCHAR": jdbcType = "VARCHAR"; break;
			case "CLOB": jdbcType = "CLOB"; break;
			case "CHAR": jdbcType = "CHAR"; break;
			case "DATE": jdbcType = "DATE"; break;
			case "NUMBER": jdbcType = "NUMERIC"; break;
			case "INTEGER": jdbcType = "INTEGER"; break;
			/*更多类型在此补充*/
			default: jdbcType = "UNKONW-JDBCTYPE"; break;
		}
		return jdbcType;
	}
	
	public static String dataType2JdbcTypeMysql(String dataType){
		String jdbcType = null;
		/*mysql类型待修改兼容*/
		switch(dataType){
			case "TIMESTAMP": jdbcType = "TIMESTAMP"; break;
			case "DATETIME": jdbcType = "TIMESTAMP"; break;
			case "DATE": jdbcType = "DATE"; break;
			case "LONGTEXT": jdbcType = "CLOB"; break;
			case "MEDIUMTEXT": jdbcType = "CLOB"; break;
			case "TINYTEXT": jdbcType = "CLOB"; break;
			case "VARCHAR": jdbcType = "VARCHAR"; break;
			case "CHAR": jdbcType = "CHAR"; break;
			case "BIT": jdbcType = "BIT"; break;
			case "DECIMAL": jdbcType = "DECIMAL"; break;
			case "DOUBLE": jdbcType = "DOUBLE"; break;
			case "FLOAT": jdbcType = "FLOAT"; break;
			case "BIGINT": jdbcType = "BIGINT"; break;
			case "INTEGER": jdbcType = "INTEGER"; break;
			case "INT": jdbcType = "INTEGER"; break;
			case "MEDIUMINT": jdbcType = "INTEGER"; break;
			case "SMALLINT": jdbcType = "INTEGER"; break;
			case "TINYINT": jdbcType = "INTEGER"; break;
			default: jdbcType = "UNKONW-JDBCTYPE"; break;
		}
		return jdbcType;
	}

}
