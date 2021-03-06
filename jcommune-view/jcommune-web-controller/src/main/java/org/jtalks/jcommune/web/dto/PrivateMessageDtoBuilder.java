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
package org.jtalks.jcommune.web.dto;

import org.jtalks.jcommune.model.entity.PrivateMessage;
import org.springframework.stereotype.Component;

/**
 * DTO builder for {@link org.jtalks.jcommune.web.dto.PrivateMessageDto} objects.
 * Used for preparing dto for the different private message types (message, reply, quote, etc.).
 *
 * @author Alexandre Teterin
 */

@Component
public class PrivateMessageDtoBuilder {


    /**
     * Create the full private message dto from {@link org.jtalks.jcommune.model.entity.PrivateMessage}
     *
     * @param pm private message for conversion
     * @return dto for full private message
     */
    public PrivateMessageDto getFullPmDtoFor(PrivateMessage pm) {
        PrivateMessageDto dto = new PrivateMessageDto();
        dto.setBody(pm.getBody());
        dto.setTitle(pm.getTitle());
        dto.setRecipient(pm.getUserTo().getUsername());
        dto.setId(pm.getId());
        return dto;
    }

    /**
     * Create the reply private message dto from {@link org.jtalks.jcommune.model.entity.PrivateMessage}
     * @param pm private message for conversion in to reply
     * @return dto for reply
     */
    public PrivateMessageDto getReplyDtoFor(PrivateMessage pm) {
        PrivateMessageDto dto = new PrivateMessageDto();
        dto.setRecipient(pm.getUserFrom().getUsername());
        dto.setTitle(pm.prepareTitleForReply());
        return dto;
    }

    /**
     * Create the quote private message dto from {@link org.jtalks.jcommune.model.entity.PrivateMessage}
     * @param pm private message for conversion in to the quote
     * @return dto for quote
     */
    public PrivateMessageDto getQuoteDtoFor(PrivateMessage pm) {
        PrivateMessageDto dto = getReplyDtoFor(pm);
        dto.setBody(pm.prepareBodyForQuote());
        return dto;
    }
}
