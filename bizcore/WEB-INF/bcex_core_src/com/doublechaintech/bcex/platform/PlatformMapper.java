
package com.doublechaintech.bcex.platform;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;

public class PlatformMapper extends BaseRowMapper<Platform>{
	
	protected Platform internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Platform platform = getPlatform();		
		 		
 		setId(platform, rs, rowNumber); 		
 		setName(platform, rs, rowNumber); 		
 		setDescription(platform, rs, rowNumber); 		
 		setVersion(platform, rs, rowNumber);

		return platform;
	}
	
	protected Platform getPlatform(){
		return new Platform();
	}		
		
	protected void setId(Platform platform, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(PlatformTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		platform.setId(id);
	}
		
	protected void setName(Platform platform, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(PlatformTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		platform.setName(name);
	}
		
	protected void setDescription(Platform platform, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String description = rs.getString(PlatformTable.COLUMN_DESCRIPTION);
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		platform.setDescription(description);
	}
		
	protected void setVersion(Platform platform, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(PlatformTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		platform.setVersion(version);
	}
		
		

}


