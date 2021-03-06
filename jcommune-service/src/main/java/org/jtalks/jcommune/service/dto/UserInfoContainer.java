/**
 * Copyright (C) 2011  JTalks.org Team
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.jtalks.jcommune.service.dto;

/**
 * This class is used when transferring user profile updates
 * from web tier to the service layer. For various reasons
 * we can't use domain model class and MVC command object.
 *
 * @author Evgeniy Naumenko
 */
public class UserInfoContainer {

    private String firstName;
    private String lastName;
    private String email;
    private String currentPassword;
    private String newPassword;
    private String signature;
    private String b64EncodedAvatar;
    private String language;
    private int pageSize;


    /**
     * Create instance with required fields.
     *
     * @param firstName user's first name
     * @param lastName user's last name
     * @param email email set for user
     * @param currentPassword  current user password to verify identity, may be null is we're not changing password
     * @param newPassword  new password to be set, may be null is we're not changing password
     * @param signature user's signature
     * @param avatar  B64 encoded avatar
     * @param language  preffered language
     * @param pageSize page size choosen
     */
    public UserInfoContainer(String firstName, String lastName, String email, String currentPassword,
                             String newPassword, String signature, String avatar, String language, int pageSize) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.signature = signature;
        this.b64EncodedAvatar = avatar;
        this.language = language;
        this.pageSize = pageSize;
    }

    /**
     * Get the user's Last Name.
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return user b64EncodedAvatar
     */
    public String getB64EncodedAvatar() {
        return b64EncodedAvatar;
    }

    /**
     * @return password
     */
    public String getCurrentPassword() {
        return currentPassword;
    }


    /**
     * @return user signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @return user language
     */
    public String getLanguage() {
        return language;
    }


    /**
     * @return user page size
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     *
     * @return  new password set during profile updates
     */
    public String getNewPassword() {
        return newPassword;
    }
}
