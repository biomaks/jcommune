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
package org.jtalks.jcommune.service.exceptions;

/**
 * Exception for cases when email already exists in system.
 *
 * @author Eugeny Batov
 */
public class DuplicateEmailException extends DuplicateException {

    private static final long serialVersionUID = -1871559056638512329L;

    /**
     * Default constructor.
     */
    public DuplicateEmailException() {
        super();
    }

    /**
     * Create exception with specific message.
     *
     * @param message exception message
     */
    public DuplicateEmailException(String message) {
        super(message);
    }
}
