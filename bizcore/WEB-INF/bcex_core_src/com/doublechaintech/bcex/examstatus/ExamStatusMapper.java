
package com.doublechaintech.bcex.examstatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.platform.Platform;

public class ExamStatusMapper extends BaseRowMapper<ExamStatus>{
	
	protected ExamStatus internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ExamStatus examStatus = getExamStatus();		
		 		
 		setId(examStatus, rs, rowNumber); 		
 		setName(examStatus, rs, rowNumber); 		
 		setCode(examStatus, rs, rowNumber); 		
 		setPlatform(examStatus, rs, rowNumber); 		
 		setVersion(examStatus, rs, rowNumber);

		return examStatus;
	}
	
	protected ExamStatus getExamStatus(){
		return new ExamStatus();
	}		
		
	protected void setId(ExamStatus examStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ExamStatusTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		examStatus.setId(id);
	}
		
	protected void setName(ExamStatus examStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ExamStatusTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		examStatus.setName(name);
	}
		
	protected void setCode(ExamStatus examStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String code = rs.getString(ExamStatusTable.COLUMN_CODE);
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		examStatus.setCode(code);
	}
		 		
 	protected void setPlatform(ExamStatus examStatus, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(ExamStatusTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = examStatus.getPlatform();
 		if( platform != null ){
 			//if the root object 'examStatus' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		examStatus.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(ExamStatus examStatus, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ExamStatusTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		examStatus.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


