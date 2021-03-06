/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions Copyright [year] [name of copyright owner]".
 *
 * Copyright 2010 Sun Microsystems, Inc.
 * Portions copyright 2012-2015 ForgeRock AS.
 */

package org.forgerock.opendj.ldap.responses;

import java.util.List;

import org.forgerock.opendj.ldap.ByteString;
import org.forgerock.opendj.ldap.DecodeException;
import org.forgerock.opendj.ldap.DecodeOptions;
import org.forgerock.opendj.ldap.controls.Control;
import org.forgerock.opendj.ldap.controls.ControlDecoder;

/**
 * A Generic Intermediate response provides a mechanism for communicating
 * unrecognized or unsupported Intermediate responses to the client.
 */
public interface GenericIntermediateResponse extends IntermediateResponse {

    @Override
    GenericIntermediateResponse addControl(Control control);

    @Override
    <C extends Control> C getControl(ControlDecoder<C> decoder, DecodeOptions options)
            throws DecodeException;

    @Override
    List<Control> getControls();

    @Override
    String getOID();

    @Override
    ByteString getValue();

    @Override
    boolean hasValue();

    /**
     * Sets the numeric OID, if any, associated with this intermediate response.
     *
     * @param oid
     *            The numeric OID associated with this intermediate response, or
     *            {@code null} if there is no value.
     * @return This generic intermediate response.
     * @throws UnsupportedOperationException
     *             If this intermediate response does not permit the response
     *             name to be set.
     */
    GenericIntermediateResponse setOID(String oid);

    /**
     * Sets the value, if any, associated with this intermediate response. Its
     * format is defined by the specification of this intermediate response.
     * <p>
     * If {@code value} is not an instance of {@code ByteString} then it will be
     * converted using the {@link ByteString#valueOfObject(Object)} method.
     *
     * @param value
     *            The value associated with this intermediate response, or
     *            {@code null} if there is no value.
     * @return This generic intermediate response.
     * @throws UnsupportedOperationException
     *             If this intermediate response does not permit the response
     *             value to be set.
     */
    GenericIntermediateResponse setValue(Object value);

}
