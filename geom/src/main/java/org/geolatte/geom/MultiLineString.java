/*
 * This file is part of the GeoLatte project.
 *
 *     GeoLatte is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     GeoLatte is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with GeoLatte.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (C) 2010 - 2011 and Ownership of code is shared by:
 * Qmino bvba - Romeinsestraat 18 - 3001 Heverlee  (http://www.qmino.com)
 * Geovise bvba - Generaal Eisenhowerlei 9 - 2140 Antwerpen (http://www.geovise.com)
 */

package org.geolatte.geom;

import org.geolatte.geom.crs.CoordinateReferenceSystem;

/**
 * A {@code GeometryCollection} of {@code LineString}s.
 *
 * @author Karel Maesen, Geovise BVBA
 *         creation-date: 4/8/11
 */
public class MultiLineString<P extends Position> extends AbstractGeometryCollection<P, LineString<P>> implements Linear {


    /**
     * Constructs a <code>MultiLineString</code> from the specified <code>LineString</code>s
     *
     * @param lineStrings the element <code>LineString</code>s for the constructed <code>MultiLineString</code>
     */
//    @SafeVarargs
    public MultiLineString(LineString<P>... lineStrings) {
        super(lineStrings);
    }

    public MultiLineString(CoordinateReferenceSystem<P> crs) {
        super(crs);
    }



    @Override
    public Position getStartPosition() {
        return getPositionN(0);
    }

    @Override
    public Position getEndPosition() {
        return getPositionN(getNumPositions() - 1);
    }

    @Override
    public int getDimension() {
        return 1;
    }

    @Override
    public GeometryType getGeometryType() {
        return GeometryType.MULTILINESTRING;
    }

    @Override
    public Class<? extends Geometry> getComponentType() {
        return LineString.class;
    }

    @SuppressWarnings("unchecked")
    public <Q extends Position> MultiLineString<Q> as(Class<Q> castToType){
        checkCast(castToType);
        return (MultiLineString<Q>)this;
    }

}
