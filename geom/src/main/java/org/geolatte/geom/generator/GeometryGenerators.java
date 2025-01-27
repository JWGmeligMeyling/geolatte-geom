package org.geolatte.geom.generator;

import org.geolatte.geom.*;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

/**
 * Created by Karel Maesen, Geovise BVBA on 03/08/2018.
 */
public class GeometryGenerators {

    public static <P extends Position> GeometryGenerator<P, Geometry<P>> combine
            (final Random rnd, final List<GeometryGenerator<P, ? extends Geometry<P>>> generators) {
        return new CombinedGeometryGenerator<>(rnd, generators);
    }

    public static <P extends Position> GeometryGenerator<P, Geometry<P>> combine
            (final List<GeometryGenerator<P, ? extends Geometry<P>>> generators) {
        return new CombinedGeometryGenerator<>(new Random(), generators);
    }

    public static <P extends Position> GeometryGenerator<P, Point<P>> point(Envelope<P> bbox) {
        return new DefaultPointGenerator<>(bbox, new Random());
    }

    public static <P extends Position> GeometryGenerator<P, Point<P>> point(Envelope<P> bbox, Random rnd) {
        return new DefaultPointGenerator<>(bbox, rnd);
    }

    public static <P extends Position> GeometryGenerator<P, LineString<P>> lineString(int numPnts, Envelope<P> bbox,
                                                                                      Random rnd) {
        return new DefaultLineStringGenerator<>(numPnts, false, bbox, rnd);
    }

    public static <P extends Position> GeometryGenerator<P, LineString<P>> lineString(int numPnts, Envelope<P> bbox) {
        return new DefaultLineStringGenerator<>(numPnts, false, bbox, new Random());
    }

    public static <P extends Position> GeometryGenerator<P, Polygon<P>> polygon(int numPnts, Envelope<P> bbox,
                                                                                Random rnd) {
        return new DefaultPolygonGenerator<>(numPnts, bbox, rnd);
    }

    public static <P extends Position> GeometryGenerator<P, Polygon<P>> polygon(int numPnts, Envelope<P> bbox) {
        return new DefaultPolygonGenerator<>(numPnts, bbox, new Random());
    }

    public static <P extends Position> GeometryGenerator<P, MultiPoint<P>> multiPoint(int numPnts, Envelope<P> bbox,
                                                                                      Random rnd) {
        return new DefaultMultiPointGenerator<>(numPnts, bbox, rnd);
    }

    public static <P extends Position> GeometryGenerator<P, MultiPoint<P>> multiPoint(int numPnts, Envelope<P> bbox) {
        return new DefaultMultiPointGenerator<>(numPnts, bbox, new Random());
    }

    public static <P extends Position> GeometryGenerator<P, MultiLineString<P>> multiLineString(int numLines,
                                                                                                int numPoints, Envelope<P> bbox, Random rnd) {
        return new DefaultMultiLineStringGenerator<>(numLines, numPoints, bbox, rnd);
    }

    public static <P extends Position> GeometryGenerator<P, MultiLineString<P>> multiLineString(int numLines,
                                                                                                int numPoints, Envelope<P> bbox) {
        return new DefaultMultiLineStringGenerator<>(numLines, numPoints, bbox, new Random());
    }

    public static <P extends Position> GeometryGenerator<P, MultiPolygon<P>> multiPolygon
            (int numLines, int numPoints, Envelope<P> bbox, Random rnd) {
        return new DefaultMultiPolygonGenerator<>(numLines, numPoints, bbox, rnd);
    }

    public static <P extends Position> GeometryGenerator<P, MultiPolygon<P>> multiPolygon
            (int numLines, int numPoints, Envelope<P> bbox) {
        return new DefaultMultiPolygonGenerator<>(numLines, numPoints, bbox, new Random());
    }

    @SafeVarargs
    public static <P extends Position> GeometryGenerator<P, GeometryCollection<P>> geometryCollection
            (int numGeoms, Random rnd, GeometryGenerator<P, ? extends Geometry<P>>... generators) {

        GeometryGenerator<P, Geometry<P>> combine = combine(asList(generators));
        return new DefaultGeometryCollectionGenerator<>(numGeoms, combine, rnd);
    }

    @SafeVarargs
    public static <P extends Position> GeometryGenerator<P, GeometryCollection<P>> geometryCollection
            (int numGeoms, GeometryGenerator<P, ? extends Geometry<P>>... generators) {
        return geometryCollection(numGeoms, new Random(), generators);
    }

}
