package com.github.e13mort.documenteditor.component;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@SuppressWarnings("unused")
interface EditorView {

    /**
     * Toggle specified pin to be visible
     *
     * @param type requested pin to be updated
     */
    void showPin(@NonNull EditorModel.PinType type);

    /**
     * Toggle specified pin to be invisible
     *
     * @param type requested pin to be updated
     */
    void hidePin(@NonNull EditorModel.PinType type);

    /**
     * Updates ui position of the specified pin
     *
     * @param type     requested pin to be updated
     * @param position new position of the pin
     */
    void updatePinUiPosition(@NonNull EditorModel.PinType type, @NonNull RectF position);

    /**
     * Set listener to be called when user interacts with the editor view
     *
     * @param listener touch listener
     */
    void setTouchListener(@Nullable TouchListener listener);

    /**
     * Ask view for self invalidation
     */
    void requestViewInvalidation();

    /**
     * Set listener to be called when user interacts with the keyboard
     *
     * @param listener keyboard listener
     */
    void setKeyboardListener(@Nullable KeyboardListener listener);

    void setDrawListener(@Nullable DrawListener listener);

    interface TouchListener {
        void onClick(float x, float y);

        void onDoubleClick(float x, float y);
    }

    interface KeyboardListener {
        void onKeyPressed(char letter);

        void onRemovePreviousLetterPressed();
    }

    interface DrawListener {
        void onDrawRequested(@NonNull Canvas canvas);
    }

    EditorView EMPTY = new EditorView() {
        @Override
        public void showPin(@NonNull EditorModel.PinType type) {

        }

        @Override
        public void hidePin(@NonNull EditorModel.PinType type) {

        }

        @Override
        public void updatePinUiPosition(@NonNull EditorModel.PinType type, @NonNull RectF position) {

        }

        @Override
        public void setTouchListener(@Nullable TouchListener listener) {

        }

        @Override
        public void requestViewInvalidation() {

        }

        @Override
        public void setKeyboardListener(@Nullable KeyboardListener listener) {

        }

        @Override
        public void setDrawListener(@Nullable DrawListener listener) {

        }
    };
}
