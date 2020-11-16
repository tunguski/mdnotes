package pl.matsuo.mdnotes.view;

import static j2html.TagCreator.attrs;
import static j2html.TagCreator.b;
import static j2html.TagCreator.div;
import static j2html.TagCreator.li;
import static j2html.TagCreator.ol;
import static j2html.TagCreator.text;
import static j2html.TagCreator.textarea;

import j2html.tags.ContainerTag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.matsuo.core.util.desktop.BootstrapIcons;
import pl.matsuo.core.util.desktop.IRequest;
import pl.matsuo.core.util.desktop.IView;
import pl.matsuo.core.util.desktop.component.FormComponents;
import pl.matsuo.core.util.desktop.component.ViewComponents;
import pl.matsuo.mdnotes.model.MdNotesModel;

@Slf4j
@RequiredArgsConstructor
public class MdNotesMainView implements IView<IRequest, MdNotesModel> {

  final ViewComponents viewComponents;
  final FormComponents formComponents;

  @Override
  public ContainerTag view(IRequest request, MdNotesModel model) {
    return viewComponents.pageTemplate(
        "Markdown Notes",
        div(
            attrs(".row"),
            div(
                attrs(".col-2.border-right.bg-light.left-bar.file-listing"),
                fileListing(),
                div(
                    attrs(".toolbar.pt-3.pb-3.text-right"),
                    // BootstrapIcons.gear.svg("mr-3"),
                    BootstrapIcons.file_plus.svg("mr-3"),
                    BootstrapIcons.folder_plus.svg())),
            div(
                attrs(".col-10.left-bar"),
                textarea(text("test\t test! \t test!")),
                div(attrs(".toolbar.pt-3.pb-3"), BootstrapIcons.gear.svg()))));
  }

  private ContainerTag fileListing() {
    return ol(
        attrs(".list-unstyled"),
        li("one"),
        li("two"),
        li("three"),
        li("four"),
        li(
            b("folder"),
            ol(attrs(".list-unstyled"), li("one"), li("two"), li("three"), li("four"))));
  }
}
