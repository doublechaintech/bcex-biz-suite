
package com.doublechaintech.bcex.examranking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.platform.Platform;

public class ExamRankingMapper extends BaseRowMapper<ExamRanking>{
	
	protected ExamRanking internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ExamRanking examRanking = getExamRanking();		
		 		
 		setId(examRanking, rs, rowNumber); 		
 		setName(examRanking, rs, rowNumber); 		
 		setAvatar(examRanking, rs, rowNumber); 		
 		setPlatform(examRanking, rs, rowNumber); 		
 		setVersion(examRanking, rs, rowNumber);

		return examRanking;
	}
	
	protected ExamRanking getExamRanking(){
		return new ExamRanking();
	}		
		
	protected void setId(ExamRanking examRanking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ExamRankingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		examRanking.setId(id);
	}
		
	protected void setName(ExamRanking examRanking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ExamRankingTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		examRanking.setName(name);
	}
		
	protected void setAvatar(ExamRanking examRanking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String avatar = rs.getString(ExamRankingTable.COLUMN_AVATAR);
		if(avatar == null){
			//do nothing when nothing found in database
			return;
		}
		
		examRanking.setAvatar(avatar);
	}
		 		
 	protected void setPlatform(ExamRanking examRanking, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(ExamRankingTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = examRanking.getPlatform();
 		if( platform != null ){
 			//if the root object 'examRanking' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		examRanking.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(ExamRanking examRanking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ExamRankingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		examRanking.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


