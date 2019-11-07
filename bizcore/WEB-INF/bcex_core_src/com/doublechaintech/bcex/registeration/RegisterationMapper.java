
package com.doublechaintech.bcex.registeration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.changerequest.ChangeRequest;

public class RegisterationMapper extends BaseRowMapper<Registeration>{
	
	protected Registeration internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Registeration registeration = getRegisteration();		
		 		
 		setId(registeration, rs, rowNumber); 		
 		setNickName(registeration, rs, rowNumber); 		
 		setAvarta(registeration, rs, rowNumber); 		
 		setChangeRequest(registeration, rs, rowNumber); 		
 		setVersion(registeration, rs, rowNumber);

		return registeration;
	}
	
	protected Registeration getRegisteration(){
		return new Registeration();
	}		
		
	protected void setId(Registeration registeration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RegisterationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		registeration.setId(id);
	}
		
	protected void setNickName(Registeration registeration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String nickName = rs.getString(RegisterationTable.COLUMN_NICK_NAME);
		if(nickName == null){
			//do nothing when nothing found in database
			return;
		}
		
		registeration.setNickName(nickName);
	}
		
	protected void setAvarta(Registeration registeration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String avarta = rs.getString(RegisterationTable.COLUMN_AVARTA);
		if(avarta == null){
			//do nothing when nothing found in database
			return;
		}
		
		registeration.setAvarta(avarta);
	}
		 		
 	protected void setChangeRequest(Registeration registeration, ResultSet rs, int rowNumber) throws SQLException{
 		String changeRequestId = rs.getString(RegisterationTable.COLUMN_CHANGE_REQUEST);
 		if( changeRequestId == null){
 			return;
 		}
 		if( changeRequestId.isEmpty()){
 			return;
 		}
 		ChangeRequest changeRequest = registeration.getChangeRequest();
 		if( changeRequest != null ){
 			//if the root object 'registeration' already have the property, just set the id for it;
 			changeRequest.setId(changeRequestId);
 			
 			return;
 		}
 		registeration.setChangeRequest(createEmptyChangeRequest(changeRequestId));
 	}
 	
	protected void setVersion(Registeration registeration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RegisterationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		registeration.setVersion(version);
	}
		
		

 	protected ChangeRequest  createEmptyChangeRequest(String changeRequestId){
 		ChangeRequest changeRequest = new ChangeRequest();
 		changeRequest.setId(changeRequestId);
 		changeRequest.setVersion(Integer.MAX_VALUE);
 		return changeRequest;
 	}
 	
}


