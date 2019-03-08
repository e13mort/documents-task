package com.github.e13mort.documenteditor.component;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.support.annotation.NonNull;

@SuppressWarnings("unused")
interface EditorModel {

    interface PinInfo {
        /**
         * @return view position of a pin
         */
        @NonNull
        RectF viewPosition();

        PinInfo EMPTY = new PinInfo() {
            @NonNull
            @Override
            public RectF viewPosition() {
                return new RectF();
            }
        };
    }

    enum PinType {ANCHOR, CURSOR}

    /**
     * Editor might be in a one specific state at a time
     * In CURSOR state the cursor and anchor pins are point to the same position in text
     * In TEXT_SELECTION state the cursor and anchor pins are point to the different positions.
     * The anchor pin is always precedes the cursor pin
     */
    enum EditorState {CURSOR, TEXT_SELECTION}

    /**
     * @return current editor's state at the moment
     */
    @NonNull
    EditorState currentModelState();

    /**
     * @param newState explicitly move editor to a new state
     */
    void updateCurrentStateTo(@NonNull EditorState newState);

    /**
     * @param type which kind of the pins is required
     * @return pin info which might be used to obtain its UI position
     */
    @NonNull
    PinInfo pinInfo(@NonNull PinType type);

    /**
     * @param type pin to be moved
     * @param x    new x position
     * @param y    new y position
     */
    void movePinTo(@NonNull PinType type, float x, float y);

    /**
     * @param letter insert letter at the cursor position.
     *               If current editor's state is TEXT_SELECTION all selected content will be replaced
     *               by inserted letter and editor will be switched to the CURSOR state.
     */
    void insertLetter(char letter);

    /**
     * remove the letter that placed before the cursor.
     * If current editor's state is TEXT_SELECTION all selected content will be removed
     * and editor will be switched to the CURSOR state.
     */
    void removePreviousChar();

    /**
     * Draw current model on the provided canvas
     *
     * @param canvas
     */
    @SuppressWarnings("JavaDoc")
    void draw(@NonNull Canvas canvas);

    EditorModel EMPTY = new EditorModel() {
        @NonNull
        @Override
        public EditorState currentModelState() {
            return EditorState.CURSOR;
        }

        @Override
        public void updateCurrentStateTo(@NonNull EditorState newState) {

        }

        @NonNull
        @Override
        public PinInfo pinInfo(@NonNull PinType type) {
            return PinInfo.EMPTY;
        }

        @Override
        public void movePinTo(@NonNull PinType type, float x, float y) {

        }

        @Override
        public void insertLetter(char letter) {

        }

        @Override
        public void removePreviousChar() {

        }

        @Override
        public void draw(@NonNull Canvas canvas) {

        }
    };

}
