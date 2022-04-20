package com.premukkoji.mobileappws.userservice;

import com.premukkoji.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.premukkoji.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.premukkoji.mobileappws.ui.model.response.UserRest;

public interface UserService {
	UserRest getUser(String userId);
	UserRest createUser(UserDetailsRequestModel userDetails);
	UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails);
	void deleteUser(String userId);
}
