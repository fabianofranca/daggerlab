package com.fabianofranca.daggerlab.core.presentation;

import android.view.View;

@FunctionalInterface
public interface ViewProvider {
    View getView();
}