/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2024, Arnaud Roques
 *
 * Project Info:  https://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * https://plantuml.com/patreon
 * https://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; we can redistribute it and or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * at our option any later version.
 *
 * PlantUML is distributed in the hope that it will be useful, but
 * without any warranty; without even the implied warranty of merchantability
 * or fitness for a particular purpose. See the GNU General Public
 * License for more details.
 *
 * We should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, Massachusetts 02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 *
 *
 */
package net.sourceforge.plantuml.core;

import java.io.IOException;
import java.io.OutputStream;

import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.api.ApiStable;
import net.sourceforge.plantuml.klimt.creole.Display;
import net.sourceforge.plantuml.klimt.drawing.UGraphic;

/**
 * Represents a single diagram. A diagram can be a Unified Modeling Language diagram
 * (sequence diagram, class diagram, and so on) or a non Unified Modeling Language diagram.
 */
@ApiStable
public interface Diagram {

    /**
     * Exports the diagram as an image in a given format. Some diagrams may consist of
     * multiple images, for example diagrams that include a new page instruction.
     *
     * @param outputStream the stream to which the image is written
     * @param index the index of the image to export, usually zero
     * @param fileFormatOption the format in which the image is generated
     * @return the description of the exported image
     * @throws IOException if an input or output error occurs during writing
     */
    ImageData exportDiagram(OutputStream outputStream, int index, FileFormatOption fileFormatOption) throws IOException;

    /**
     * Renders the diagram using the provided graphics implementation.
     *
     * @param graphic the graphics implementation that receives the rendering commands
     * @param fileFormatOption the output format settings
     */
    void exportDiagramGraphic(UGraphic graphic, FileFormatOption fileFormatOption);

    /**
     * Returns the number of images produced by this diagram.
     *
     * @return the number of generated images, usually one
     */
    int getNbImages();

    /**
     * Returns the number of horizontal split pages used by this diagram.
     *
     * @return the number of horizontal split pages
     */
    int getSplitPagesHorizontal();

    /**
     * Returns the number of vertical split pages used by this diagram.
     *
     * @return the number of vertical split pages
     */
    int getSplitPagesVertical();

    /**
     * Returns a textual description of the diagram.
     *
     * @return the diagram description
     */
    DiagramDescription getDescription();

    /**
     * Returns additional metadata associated with the diagram.
     *
     * @return the metadata string or null when absent
     */
    String getMetadata();

    /**
     * Returns any warning or error message generated during processing of the diagram.
     *
     * @return the warning or error message, or null when none
     */
    String getWarningOrError();

    /**
     * Returns the original textual source from which the diagram was created.
     *
     * @return the source of the diagram
     */
    UmlSource getSource();

    /**
     * Indicates whether the diagram contains link definitions.
     *
     * @return true if the diagram contains links, otherwise false
     */
    boolean hasUrl();

    /**
     * Returns the display representation of the diagram title.
     *
     * @return the title display or null when none is defined
     */
    Display getTitleDisplay();

    /**
     * Returns installation or environment requirements needed for this diagram,
     * if any exist.
     *
     * @return the installation requirement or null when none is required
     */
    InstallationRequirement getInstallationRequirement();

}
