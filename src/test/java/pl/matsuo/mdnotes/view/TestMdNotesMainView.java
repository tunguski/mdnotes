package pl.matsuo.mdnotes.view;

import static java.util.Collections.emptyMap;
import static pl.matsuo.core.util.desktop.ViewTestUtil.storeView;
import static pl.matsuo.core.util.desktop.mvc.IRequest.request;
import static pl.matsuo.mdnotes.MdNotes.mdNotesCss;

import org.junit.Test;
import pl.matsuo.core.util.desktop.component.FormComponents;
import pl.matsuo.core.util.desktop.component.ViewComponents;
import pl.matsuo.mdnotes.component.ViewTemplate;
import pl.matsuo.mdnotes.model.MdNotesModel;

public class TestMdNotesMainView {

  ViewComponents viewComponents = new ViewComponents(mdNotesCss);
  FormComponents formComponents = new FormComponents();
  ViewTemplate viewTemplate = new ViewTemplate(viewComponents, formComponents);

  @Test
  public void mainView() {
    MdNotesMainView view = new MdNotesMainView(viewTemplate);

    MdNotesModel model = new MdNotesModel();

    String rendered = view.view(request("/", emptyMap()), model).renderFormatted();

    storeView("main.html", rendered);
  }
}
