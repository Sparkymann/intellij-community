package com.intellij.structuralsearch.plugin.ui;

import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.structuralsearch.SSRBundle;
import com.intellij.usages.Usage;
import com.intellij.usages.UsageTarget;
import com.intellij.usages.UsageView;
import com.intellij.usages.UsageViewPresentation;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Maxim.Mossienko
 * Date: Mar 9, 2005
 * Time: 2:47:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class UsageViewContext {
  protected final SearchContext mySearchContext;
  private UsageView myUsageView;
  protected final Configuration myConfiguration;
  private Set<Usage> myExcludedSet;
  private SearchCommand myCommand;

  protected UsageViewContext(SearchContext _searchContext,Configuration _configuration) {
    myConfiguration = _configuration;
    mySearchContext = _searchContext;
  }

  public boolean isExcluded(Usage usage) {
    if (myExcludedSet == null) myExcludedSet = myUsageView.getExcludedUsages();
    return myExcludedSet.contains(usage);
  }

  public UsageView getUsageView() {
    return myUsageView;
  }

  public void setUsageView(final UsageView usageView) {
    myUsageView = usageView;
  }

  public Configuration getConfiguration() {
    return myConfiguration;
  }

  public SearchCommand getCommand() {
    if (myCommand == null) setCommand(createCommand());
    return myCommand;
  }

  private void setCommand(final SearchCommand command) {
    myCommand = command;
  }

  protected SearchCommand createCommand() {
    return new SearchCommand(mySearchContext.getProject(), this);
  }

  protected String _getPresentableText() {
    return myConfiguration.getMatchOptions().getSearchPattern();
  }

  public UsageTarget getTarget() {
    return new MyUsageTarget(_getPresentableText());
  }

  public void configure(final UsageViewPresentation presentation) {
    String s = _getPresentableText();
    if (s.length() > 15) s = s.substring(0,15) + "...";
    final String usagesString = SSRBundle.message("occurences.of", s);
    presentation.setUsagesString(usagesString);
    presentation.setTabText(StringUtil.capitalize(usagesString));
  }

  private static class MyUsageTarget implements UsageTarget {
    private final String myPresentableText;

    MyUsageTarget(String str) {
      myPresentableText = str;
    }

    final ItemPresentation presentation = new ItemPresentation() {
      @Override
      public String getPresentableText() {
        return myPresentableText;
      }

      @Override
      public String getLocationString() {
        //noinspection HardCodedStringLiteral
        return "Do Not Know Where";
      }

      @Override
      public Icon getIcon(boolean open) {
        return null;
      }
    };

    @Override
    public void findUsages() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void findUsagesInEditor(@NotNull FileEditor editor) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void highlightUsages(@NotNull PsiFile file, @NotNull Editor editor, boolean clearHighlights) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean isValid() {
      return true;
    }

    @Override
    public boolean isReadOnly() {
      return true;
    }

    @Override
    public VirtualFile[] getFiles() {
      return null;
    }

    @Override
    public void update() {
    }

    @Override
    public String getName() {
      //noinspection HardCodedStringLiteral
      return "my name";
    }

    @Override
    public ItemPresentation getPresentation() {
      return presentation;
    }

    @Override
    public void navigate(boolean requestFocus) {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean canNavigate() {
      return false;
    }

    @Override
    public boolean canNavigateToSource() {
      return false;
    }
  }
}
