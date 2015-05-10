package com.brainyway.mrs.tpms.users;

import com.brainyway.mrs.tpms.model.TPMSUser;

public interface TPMSUserDao {

	TPMSUser findByUserName(String username);

}