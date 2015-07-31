package com.itextpdf.model;

import com.itextpdf.canvas.color.Color;

public enum Property {

    AUTO_SCALE,
    BACKGROUND,
    BASE_DIRECTION,
    BORDER,
    BORDER_BOTTOM,
    BORDER_LEFT,
    BORDER_RIGHT,
    BORDER_TOP,
    BOTTOM,
    CHARACTER_SPACING(true),
    COLSPAN,
    COLUMN_WIDTHS,
    FIRST_LINE_INDENT(true),
    FONT(true),
    FONT_COLOR(true),
    FONT_KERNING(true),
    FONT_SIZE(true),
    HEIGHT,
    HORIZONTAL_ALIGNMENT(true),
    /**
     * Value of 1 is equivalent to no scaling
     **/
    HORIZONTAL_SCALING,
    KEEP_TOGETHER(true),
    LEADING,
    LEFT,
    LIST_SYMBOL,
    LIST_SYMBOL_INDENT,
    MARGIN_BOTTOM,
    MARGIN_LEFT,
    MARGIN_RIGHT,
    MARGIN_TOP,
    PADDING_BOTTOM,
    PADDING_LEFT,
    PADDING_RIGHT,
    PADDING_TOP,
    PAGE_NUMBER,
    POSITION,
    RIGHT,
    ROTATION_ALIGNMENT,
    ROTATION_ANGLE,
    /**
     * The vertical shift of the element content, which is the result of the height changes on rotation layout
     */
    ROTATION_LAYOUT_SHIFT,
    /**
     *  If defined, determines the specific point of rotation
     */
    ROTATION_POINT_X,
    ROTATION_POINT_Y,
    ROW,
    ROWSPAN,
    SPACING_RATIO(true),
    STROKE_COLOR,
    STROKE_WIDTH,
    TAB_ANCHOR,
    TAB_DEFAULT,
    TAB_LEADER,
    TAB_STOPS,
    TEXT_RENDERING_MODE(true),
    TEXT_RISE(true),
    TOP,
    TRANSFORMATION_MATRIX,
    /**
     * Value of 1 is equivalent to no scaling
     **/
    VERTICAL_ALIGNMENT,
    VERTICAL_SCALING,
    WIDTH,
    WORD_SPACING(true),
    X,
    X_DISTANCE,
    Y,
    Y_DISTANCE;


    private boolean inherited;

    Property() {
        this.inherited = false;
    }

    Property(boolean inherited) {
        this.inherited = inherited;
    }

    public boolean isInherited() {
        return inherited;
    }


    public enum BaseDirection {
        LTR,
        RTL
    }

    public enum HorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT,
        JUSTIFIED,
        JUSTIFIED_ALL,
    }

    public enum VerticalAlignment {
        TOP,
        MIDDLE,
        BOTTOM
    }

    public static final class TextRenderingMode {
        private TextRenderingMode() {}

        public static final int TEXT_RENDERING_MODE_FILL = 0;
        public static final int TEXT_RENDERING_MODE_STROKE = 1;
        public static final int TEXT_RENDERING_MODE_FILL_STROKE = 2;
        public static final int TEXT_RENDERING_MODE_INVISIBLE = 3;
        public static final int TEXT_RENDERING_MODE_FILL_CLIP = 4;
        public static final int TEXT_RENDERING_MODE_STROKE_CLIP = 5;
        public static final int TEXT_RENDERING_MODE_FILL_STROKE_CLIP = 6;
        public static final int TEXT_RENDERING_MODE_CLIP = 7;
    }

    public static class Background {
        protected Color color;
        protected float extraLeft;
        protected float extraRight;
        protected float extraTop;
        protected float extraBottom;

        public Background(Color color) {
            this(color, 0, 0, 0, 0);
        }

        public Background(Color color, float extraLeft, final float extraTop, final float extraRight, float extraBottom) {
            this.color = color;
            this.extraLeft = extraLeft;
            this.extraRight = extraRight;
            this.extraTop = extraTop;
            this.extraBottom = extraBottom;
        }

        public Color getColor() {
            return color;
        }

        public float getExtraLeft() {
            return extraLeft;
        }

        public float getExtraRight() {
            return extraRight;
        }

        public float getExtraTop() {
            return extraTop;
        }

        public float getExtraBottom() {
            return extraBottom;
        }
    }

    public static class Leading {
        public static final int FIXED = 1;
        public static final int MULTIPLIED = 2;

        protected int type;
        protected float value;

        public Leading(int type, float value) {
            this.type = type;
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public float getValue() {
            return value;
        }
    }

    public enum ListNumberingType {
        DECIMAL,
        ROMAN_LOWER,
        ROMAN_UPPER,
        ENGLISH_LOWER,
        ENGLISH_UPPER,
        GREEK_LOWER,
        GREEK_UPPER
    }

    public enum TabAlignment {
        LEFT,
        RIGHT,
        CENTER,
        ANCHOR
    }

    // TODO boolean?
    public enum FontKerning {
        YES,
        NO
    }

}
