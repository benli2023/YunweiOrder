package javacommon.util;

import static org.apache.commons.digester3.binder.DigesterLoader.newLoader;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.annotations.FromAnnotationsRuleModule;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.SAXException;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import com.yunwei.order.controller.colmodel.ColModelProfile;
import com.yunwei.order.controller.colmodel.ColModelRoot;

public class ColModelFactory {

	private final String colModelPath;

	private final ResourceLoader resourceLoader;
	
	private final ConcurrentLinkedHashMap<String, ColModelRoot> colModelCache;

	private final DigesterLoader digesterLoader = newLoader(new FromAnnotationsRuleModule() {
		@Override
		protected void configureRules() {
			bindRulesFrom(ColModelRoot.class);
		} 
	});

	public ColModelFactory(String colModelPath, ResourceLoader resourceLoader,int capacity) {
		super();
		this.colModelPath = colModelPath;
		if (resourceLoader == null) {
			this.resourceLoader = new DefaultResourceLoader();
		} else {
			this.resourceLoader = resourceLoader;
		}
		colModelCache = new ConcurrentLinkedHashMap.Builder<String, ColModelRoot>().maximumWeightedCapacity(capacity).build();
	}

	public ColModelProfile getColModel(String modelxml,String profileId)
			throws FileNotFoundException, IOException, SAXException {
		ColModelRoot result = null;
		if ((result = colModelCache.get(modelxml)) == null) {
			Digester digester = digesterLoader.newDigester();
			Resource resource = resourceLoader.getResource(colModelPath.concat(modelxml));
			ColModelRoot colModelRoot = (ColModelRoot) digester.parse(resource.getInputStream());
			result = colModelCache.putIfAbsent(modelxml, colModelRoot);
			result = (result == null ? colModelRoot : result);
		}
		  System.out.println("Weighed size = " + colModelCache.weightedSize());
		  System.out.println("Capacity = " + colModelCache.capacity());
		return result.getProfile(profileId);
	}
	

	 /**
	 * @param args
	 */
	 public static void main(String[] args) {
	 try {
	 
	 ColModelProfile colModelProfile=new ColModelFactory("E:\\workspace\\OpenSource\\RapidFramework\\YunweiOrder\\src\\main\\java\\com\\yunwei\\order\\controller\\colmodel\\",new FileSystemResourceLoader(),4).getColModel("category-colmodel.xml",null);
	 
	System.out.println( colModelProfile.getColModels().size());
	 } catch (FileNotFoundException e) {
	 e.printStackTrace();
	 } catch (IOException e) {
	 e.printStackTrace();
	 } catch (SAXException e) {
	 e.printStackTrace();
	 }
	
	 }

}
