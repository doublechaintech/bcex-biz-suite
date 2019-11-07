
package com.doublechaintech.bcex.changerequesttype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.platform.Platform;

public class ChangeRequestTypeMapper extends BaseRowMapper<ChangeRequestType>{
	
	protected ChangeRequestType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ChangeRequestType changeRequestType = getChangeRequestType();		
		 		
 		setId(changeRequestType, rs, rowNumber); 		
 		setName(changeRequestType, rs, rowNumber); 		
 		setCode(changeRequestType, rs, rowNumber); 		
 		setIcon(changeRequestType, rs, rowNumber); 		
 		setDisplayOrder(changeRequestType, rs, rowNumber); 		
 		setPlatform(changeRequestType, rs, rowNumber); 		
 		setVersion(changeRequestType, rs, rowNumber);

		return changeRequestType;
	}
	
	protected ChangeRequestType getChangeRequestType(){
		return new ChangeRequestType();
	}		
		
	protected void setId(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ChangeRequestTypeTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setId(id);
	}
		
	protected void setName(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ChangeRequestTypeTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setName(name);
	}
		
	protected void setCode(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String code = rs.getString(ChangeRequestTypeTable.COLUMN_CODE);
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setCode(code);
	}
		
	protected void setIcon(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String icon = rs.getString(ChangeRequestTypeTable.COLUMN_ICON);
		if(icon == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setIcon(icon);
	}
		
	protected void setDisplayOrder(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer displayOrder = rs.getInt(ChangeRequestTypeTable.COLUMN_DISPLAY_ORDER);
		if(displayOrder == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setDisplayOrder(displayOrder);
	}
		 		
 	protected void setPlatform(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(ChangeRequestTypeTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = changeRequestType.getPlatform();
 		if( platform != null ){
 			//if the root object 'changeRequestType' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		changeRequestType.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(ChangeRequestType changeRequestType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ChangeRequestTypeTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequestType.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


