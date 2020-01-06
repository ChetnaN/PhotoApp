package com.photoApp.app.ws.mobile.app.ws.userservice;

import com.photoApp.app.ws.mobile.app.ws.ui.model.request.UserDetailsRequest;
import com.photoApp.app.ws.mobile.app.ws.ui.model.response.User;

public interface UserService {
 User createUser(UserDetailsRequest userDetails);
}
